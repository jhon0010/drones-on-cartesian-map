package com.restaurant.drone.domain;


import com.restaurant.drone.domain.location.DroneLocation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Drone {

    public static final int MAX_NUM_LUNCH = 3;

    private DroneId id;
    private DroneName name;
    private DroneLocation location;

    public void moveForward(){

    }

    public void turnLeft(){

    }

    public void turnRight(){

    }

}
