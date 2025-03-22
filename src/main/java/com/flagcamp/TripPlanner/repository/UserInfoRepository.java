package com.flagcamp.TripPlanner.repository;

import com.flagcamp.TripPlanner.entity.UserInfoEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserInfoRepository extends ListCrudRepository<UserInfoEntity,Long> {

}
