package com.flagcamp.TripPlanner.controller;

import com.flagcamp.TripPlanner.entity.TripPlanEntity;
import com.flagcamp.TripPlanner.model.SaveTripPlanRequest;
import com.flagcamp.TripPlanner.service.TripPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripPlanController {
    private final TripPlanService tripPlanService;

    public TripPlanController(TripPlanService tripPlanService) {
        this.tripPlanService = tripPlanService;
    }
    @GetMapping("/trip/{userId}")
    public TripPlanEntity getTripPlan(@PathVariable long userId) {
        String city = "Sample City"; // 模拟数据
        String country = "Sample Country"; // 模拟数据
        String tripDetail = "Sample Trip Detail"; // 模拟数据
        String startDate = "2023-01-01"; // 模拟数据
        String endDate = "2023-01-10"; // 模拟数据

        // 将数据暂存到缓存
        tripPlanService.saveTempData(userId, city, country,startDate,endDate, tripDetail);

        // 返回数据

        return new TripPlanEntity(null, userId, city, country, startDate, endDate, tripDetail);
    }
    @PostMapping("/save")
    public String saveTripPlan(@RequestBody SaveTripPlanRequest request) {
        tripPlanService.saveDataToDatabase(request.userId(), request.tripDetail());
        return "Trip plan saved for user: " + request.userId();
    }
}
