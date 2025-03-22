package com.flagcamp.TripPlanner;



import com.flagcamp.TripPlanner.entity.UserInfoEntity;
import com.flagcamp.TripPlanner.repository.TripPlanRepository;
import com.flagcamp.TripPlanner.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DevRunner implements ApplicationRunner {


    private static final Logger logger = LoggerFactory.getLogger(DevRunner.class);


    private final TripPlanRepository tripPlanRepository;
    private final UserInfoRepository userInfoRepository;

    public DevRunner(TripPlanRepository tripPlanRepository, UserInfoRepository userInfoRepository) {
        this.tripPlanRepository = tripPlanRepository;
        this.userInfoRepository = userInfoRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserInfoEntity userInfo1 = new UserInfoEntity(null,"123@gmail.com","1234");
        UserInfoEntity userInfo2 = new UserInfoEntity(null,"17088@mail.com","aaaa");
        userInfoRepository.save(userInfo1);
        userInfoRepository.save(userInfo2);
    }
}

