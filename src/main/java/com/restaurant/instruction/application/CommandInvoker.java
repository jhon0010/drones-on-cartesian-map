package com.restaurant.instruction.application;

import com.restaurant.drone.domain.Drone;
import com.restaurant.drone.domain.DroneName;
import com.restaurant.instruction.domain.Instruction;
import com.restaurant.instruction.domain.command.Command;
import com.restaurant.instruction.domain.command.CommandFactory;
import com.restaurant.shared.infraestructure.FileReader;
import com.restaurant.shared.infraestructure.exceptions.InputInstructionFileNotFoundException;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public class CommandInvoker {

    private static final Logger LOGGER = getLogger(CommandInvoker.class);

    public void start() throws InputInstructionFileNotFoundException {
        final Map<Drone, List<Instruction>> instructionsToExecute = loadInstructionsForFile();
        executeDroneInstructions(instructionsToExecute);
    }

    private static Map<Drone, List<Instruction>> loadInstructionsForFile() throws InputInstructionFileNotFoundException {

        List<Instruction> instructions = new ArrayList<>();
        Map<Drone, List<Instruction>> instructionsToExecute = new HashMap<>();
        Map<String, List<String>> filesAndLines = FileReader.readInputInstructionFiles();
        Drone drone;

        for (Map.Entry<String, List<String>> entry : filesAndLines.entrySet()) {

            List<Command> commands = new ArrayList<>();
            drone = new Drone(DroneName.builder().value(entry.getKey()).build());

            for (String lineInFile : entry.getValue()) {
                final char[] commandChars = lineInFile.toCharArray();
                for (char command : commandChars) {
                    commands.add(CommandFactory.getCommandInstance(command, drone));
                }
            }
            instructions.add(Instruction.builder().commands(commands).build());
            instructionsToExecute.putIfAbsent(drone,instructions);
        }
        return instructionsToExecute;
    }

    private static void executeDroneInstructions(Map<Drone, List<Instruction>> instructionsToExecute) {

        for (Map.Entry<Drone, List<Instruction>> entry : instructionsToExecute.entrySet()) {

            entry.getValue().forEach(
                    instruction -> instruction.getCommands()
                            .forEach(Command::execute));
            LOGGER.info("The final position for the drone is " + entry.getKey());
        }
    }

}
