package com.restaurant.drone.domain.location;

import com.restaurant.shared.domain.Orientation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
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
