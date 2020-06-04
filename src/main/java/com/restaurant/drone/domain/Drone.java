package com.restaurant.drone.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Drone {

    public static final int MAX_NUM_LUNCH = 3;

    private DroneId id;
    private DroneName name;
}
