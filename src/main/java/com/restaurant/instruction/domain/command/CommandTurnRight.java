package com.restaurant.instruction.domain.command;

import com.restaurant.drone.domain.Drone;

public class CommandTurnRight implements Command {

    private Drone drone;

    @Override
    public void execute() {
      this.drone.turnRight();
    }
}
