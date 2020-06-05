package com.restaurant.drone.domain;


import com.restaurant.drone.domain.location.DroneLocation;
import com.restaurant.shared.domain.Orientation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Drone {

    private static final Logger LOGGER = getLogger(Drone.class);
    public static final int MAX_NUM_LUNCH = 3;

    private DroneId id;
    private DroneName name;
    private DroneLocation location;

    public Drone(DroneName name) {
        this.name = name;
        this.location = DroneLocation.getDefault();
        this.id = new DroneId();
    }

    public void moveForward() {

        var loc = this.getLocation();

        switch (this.location.getOrientation()){
            case N:
                this.getLocation().setY(this.location.getY() + 1);
                LOGGER.info("Drone " + this.name.getValue() + " moved successfully from " + loc + " to " + this.location);
                break;
            case S:
                this.getLocation().setY(this.location.getY() - 1);
                LOGGER.info("Drone " + this.name.getValue() + " moved successfully from " + loc + " to " + this.location);
                break;
            case W:
                this.getLocation().setX(this.location.getX() - 1);
                LOGGER.info("Drone " + this.name.getValue() + " moved successfully from " + loc + " to " + this.location);
                break;
            case E:
                this.getLocation().setX(this.location.getX() + 1);
                LOGGER.info("Drone " + this.name.getValue() + " moved successfully from " + loc + " to " + this.location);
                break;
        }
    }

    public void turnLeft() {
        switch (this.location.getOrientation()){
            case N:
                this.location.setOrientation(Orientation.W);
                break;
            case S:
                this.location.setOrientation(Orientation.E);
                break;
            case W:
                this.location.setOrientation(Orientation.S);
                break;
            case E:
                this.location.setOrientation(Orientation.N);
                break;
        }
    }

    public void turnRight() {
        switch (this.location.getOrientation()){
            case N:
                this.location.setOrientation(Orientation.E);
                break;
            case S:
                this.location.setOrientation(Orientation.W);
                break;
            case W:
                this.location.setOrientation(Orientation.N);
                break;
            case E:
                this.location.setOrientation(Orientation.S);
                break;
        }
    }

}
