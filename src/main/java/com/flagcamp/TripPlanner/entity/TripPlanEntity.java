package com.flagcamp.TripPlanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("trips")
public record TripPlanEntity(
        @Id Long id,
        Long userId,
        String city,
        String country,
        String startDate,
        String endDate,
        String tripDetail
) {
}

