package com.restaurant.instruction.domain.command;

import com.restaurant.drone.domain.Drone;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandForward implements Command {

    private Drone drone;

    @Override
    public void execute() {
      this.drone.moveForward();
    }
}
