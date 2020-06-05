package com.restaurant.drone.domain.location;

import com.restaurant.shared.domain.Orientation;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DroneLocation {

    private int x;
    private int y;
    private Orientation orientation;

    /**
     * Default start location for a drone.
     */
    public static DroneLocation getDefault() {
        return DroneLocation.builder()
                .x(0)
                .y(0)
                .orientation(Orientation.N)
                .build();
    }

}
