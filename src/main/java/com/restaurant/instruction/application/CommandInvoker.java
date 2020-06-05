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
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public class CommandInvoker {

    private static final Logger LOGGER = getLogger(CommandInvoker.class);

    public static void start() throws InputInstructionFileNotFoundException {
        final List<Instruction> instructions = loadInstructionsForFile();

        for (Instruction instruction : instructions) {
            LOGGER.info("Instruction = " + instruction);
        }
    }

    private static List<Instruction> loadInstructionsForFile() throws InputInstructionFileNotFoundException {

        List<Instruction> instructions = new ArrayList<>();
        final Map<String, List<String>> filesAndLines = FileReader.readInputInstructionFiles();

        for (Map.Entry<String, List<String>> entry : filesAndLines.entrySet()) {

            List<Command> commands = new ArrayList<>();
            final Drone drone = new Drone(DroneName.builder().value(entry.getKey()).build());

            for (String lineInFile : entry.getValue()) {
                final char[] commandChars = lineInFile.toCharArray();
                for (char command : commandChars) {
                    commands.add(CommandFactory.getCommandInstance(command, drone));
                }
            }
            instructions.add(Instruction.builder().commands(commands).build());
        }
        return instructions;
    }

    private void executeDroneInstructions(List<Instruction> instructions) {

        instructions.forEach(
                instruction -> instruction.getCommands()
                        .forEach(Command::execute)
        );
    }

}
