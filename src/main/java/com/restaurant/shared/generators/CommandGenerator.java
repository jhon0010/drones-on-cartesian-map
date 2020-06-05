package com.restaurant.shared.generators;

import com.restaurant.drone.domain.Drone;
import com.restaurant.instruction.domain.command.Command;
import com.restaurant.instruction.domain.command.CommandFactory;
import com.restaurant.instruction.domain.command.CommandTypes;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

    public static Command generate(char commandType, Drone drone){
        return CommandFactory.getCommandInstance(commandType, drone);
    }

    public static Command generate(char commandType){
        return CommandFactory.getCommandInstance(commandType, new Drone());
    }

    public static List<Command> generate(){

        Drone defaultDrone = DroneGenerator.generate();

        return Arrays.asList(
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, defaultDrone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, defaultDrone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, defaultDrone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, defaultDrone),
                CommandFactory.getCommandInstance(CommandTypes.TURN_LEFT, defaultDrone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, defaultDrone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, defaultDrone)
        );
    }

    public static List<Command> generate(Drone drone){

        return Arrays.asList(
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, drone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, drone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, drone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, drone),
                CommandFactory.getCommandInstance(CommandTypes.TURN_LEFT, drone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, drone),
                CommandFactory.getCommandInstance(CommandTypes.FORWARD, drone)
        );
    }

}
