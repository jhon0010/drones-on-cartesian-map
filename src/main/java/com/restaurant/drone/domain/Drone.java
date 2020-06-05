package com.restaurant.drone.domain;


import com.restaurant.drone.domain.location.DroneLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Drone {

    public static final int MAX_NUM_LUNCH = 3;

    private DroneId id;
    private DroneName name;
    private DroneLocation location;

    public Drone(DroneName name) {
        this.name = name;
        this.location = new DroneLocation();
        this.id = new DroneId();
    }

    public void moveForward() {

    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

}
