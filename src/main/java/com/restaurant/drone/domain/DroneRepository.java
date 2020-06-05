package com.restaurant.drone.domain;

import java.util.List;

public interface DroneRepository {

    Drone save(Drone drone);
    Drone update(Drone drone);
    Drone getByName(DroneName droneName);
    List<Drone> getAll();
    Drone delete(DroneName droneName);
}
