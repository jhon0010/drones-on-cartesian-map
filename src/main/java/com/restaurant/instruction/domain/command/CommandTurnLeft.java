package com.restaurant.instruction.domain.command;

import com.restaurant.drone.domain.Drone;

public class CommandTurnLeft implements Command {

    private Drone drone;

    @Override
    public void execute() {
      this.drone.turnLeft();
    }
}
