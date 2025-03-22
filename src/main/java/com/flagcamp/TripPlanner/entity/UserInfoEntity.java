package com.flagcamp.TripPlanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("userinfo")
public record UserInfoEntity(
        @Id Long id,
        String email,
        String password

) {
}
