package com.flagcamp.TripPlanner.service;

import com.flagcamp.TripPlanner.repository.TripPlanRepository;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import com.flagcamp.TripPlanner.entity.TripPlanEntity;

@Service
public class TripPlanService {

    private final CacheManager cacheManager;
    private final TripPlanRepository tripPlanRepository;

    @Autowired
    public TripPlanService(CacheManager cacheManager, TripPlanRepository tripPlanRepository) {
        this.cacheManager = cacheManager;
        this.tripPlanRepository = tripPlanRepository;
    }

    // 将数据暂存到缓存
    public void saveTempData(long userId, String city, String country, String startDate, String endDate, String tripDetail) {
        Cache<String, TripPlanEntity> cache = getCache();
        TripPlanEntity tripPlan = new TripPlanEntity(null, userId, city, country, startDate, endDate, tripDetail);
        cache.put(String.valueOf(userId), tripPlan);  // 缓存中存入TripPlanEntity
    }

    // 从缓存中获取数据
    public TripPlanEntity getTempData(long userId) {
        Cache<String, TripPlanEntity> cache = getCache();
        return cache.getIfPresent(String.valueOf(userId));  // 获取缓存中的数据
    }

    // 将数据从缓存中取出并存入数据库
    public void saveDataToDatabase(long userId, String tripDetail) {
        TripPlanEntity tripPlan = getTempData(userId);
        if (tripPlan != null) {
            // 使用record的不可变特性，更新tripDetail并创建新的TripPlanEntity实例
            TripPlanEntity updatedTripPlan = new TripPlanEntity(
                    tripPlan.id(),  // 保持原有ID
                    tripPlan.userId(),
                    tripPlan.city(),
                    tripPlan.country(),
                    tripPlan.startDate(),
                    tripPlan.endDate(),
                    tripDetail // 更新tripDetail
            );
            tripPlanRepository.save(updatedTripPlan); // 存入数据库
            getCache().invalidate(String.valueOf(userId)); // 清除缓存
        } else {
            throw new RuntimeException("No data found in cache for user: " + userId);
        }
    }

    // 获取缓存实例
    private Cache<String, TripPlanEntity> getCache() {
        org.springframework.cache.Cache cache = cacheManager.getCache("tripPlanCache");
        return (Cache<String, TripPlanEntity>) cache.getNativeCache();
    }

}
