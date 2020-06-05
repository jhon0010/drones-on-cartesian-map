package com.restaurant.instruction.domain.command;

import com.restaurant.drone.domain.Drone;

public class CommandForward implements Command {

    private Drone drone;

    @Override
    public void execute() {
      this.drone.moveForward();
    }
}
