package com.restaurant.instruction.domain.command;

import com.restaurant.drone.domain.Drone;

public class CommandFactory {

    public static Command getCommandInstance(char commandIdentifier, Drone drone) {

        switch (commandIdentifier) {
            case CommandTypes.FORWARD:
                return CommandForward.builder().drone(drone).build();
            case CommandTypes.TURN_LEFT:
                return CommandTurnLeft.builder().drone(drone).build();
            case CommandTypes.TURN_RIGHT:
                return CommandTurnRight.builder().drone(drone).build();
        }
        return null;
    }

}
