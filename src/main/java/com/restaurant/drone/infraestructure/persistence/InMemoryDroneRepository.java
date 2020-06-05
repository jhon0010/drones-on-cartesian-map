package com.restaurant.drone.infraestructure.persistence;

import com.restaurant.drone.domain.Drone;
import com.restaurant.drone.domain.DroneId;
import com.restaurant.drone.domain.DroneName;
import com.restaurant.drone.domain.DroneRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDroneRepository implements DroneRepository {

    private Map<DroneName, Drone> drones = new HashMap<>();

    @Override
    public Drone save(Drone drone) {
        return drones.putIfAbsent(drone.getName(), drone);
    }

    @Override
    public Drone update(Drone drone) {
        return drones.replace(drone.getName(), drone);
    }

    @Override
    public Drone getByName(DroneName droneName) {
        return drones.get(droneName);
    }

    @Override
    public List<Drone> getAll() {
        return (List<Drone>) drones.values();
    }

    @Override
    public Drone delete(DroneName droneName) {
        return drones.remove(droneName);
    }
}
