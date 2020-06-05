package com.restaurant.drone.domain.location;

import com.restaurant.shared.domain.Orientation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DroneLocation {

    private int x;
    private int y;
    private Orientation orientation;

    /**
     * Default start location for a drone.
     */
    public DroneLocation() {
        this.x = 0;
        this.y = 0;
        this.orientation = Orientation.N;
    }
}
