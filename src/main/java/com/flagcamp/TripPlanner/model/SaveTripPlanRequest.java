package com.flagcamp.TripPlanner.model;

public record SaveTripPlanRequest(
        Long userId,
        String tripDetail
) {
}
