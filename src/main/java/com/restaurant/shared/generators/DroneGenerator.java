package com.restaurant.shared.generators;

import com.restaurant.drone.domain.Drone;
import com.restaurant.drone.domain.DroneName;

public class DroneGenerator {

    public static Drone generate() {

        return new Drone(
                DroneName.builder().value("01").build()
        );
    }

    public static Drone generate(String name) {

        return new Drone(
                DroneName.builder().value(name).build()
        );
    }

}
