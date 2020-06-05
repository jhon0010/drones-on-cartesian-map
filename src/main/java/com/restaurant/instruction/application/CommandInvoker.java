package com.restaurant.instruction.application;

import com.restaurant.drone.domain.Drone;
import com.restaurant.drone.domain.DroneName;
import com.restaurant.instruction.domain.Instruction;
import com.restaurant.instruction.domain.command.Command;
import com.restaurant.instruction.domain.command.CommandFactory;
import com.restaurant.shared.infraestructure.file.FileInputReader;
import com.restaurant.shared.infraestructure.exceptions.InputInstructionFileNotFoundException;
import com.restaurant.shared.infraestructure.file.FileOutputWriter;
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

        Map<Drone, List<Instruction>> instructionsToExecute = new HashMap<>();
        Map<String, List<String>> filesAndLines = FileInputReader.readInputInstructionFiles();
        Drone drone;

        for (Map.Entry<String, List<String>> entry : filesAndLines.entrySet()) {
            List<Instruction> instructions = new ArrayList<>();
            drone = new Drone(DroneName.builder().value(entry.getKey()
                    .substring(2,entry.getKey().indexOf('.'))).build());

            for (String lineInFile : entry.getValue()) {
                List<Command> commands = new ArrayList<>();
                final char[] commandChars = lineInFile.toCharArray();
                for (char command : commandChars) {
                    commands.add(CommandFactory.getCommandInstance(command, drone));
                }
                instructions.add(Instruction.builder().commands(commands).build());
            }
            instructionsToExecute.putIfAbsent(drone,instructions);
        }
        return instructionsToExecute;
    }

    private static void executeDroneInstructions(Map<Drone, List<Instruction>> instructionsToExecute) {

        Map<String, List<String>> droneLocations = new HashMap<>();

        for (Map.Entry<Drone, List<Instruction>> entry : instructionsToExecute.entrySet()) {

            var finalLocations = new ArrayList<String>();

            entry.getValue().forEach(instruction -> {
                instruction.getCommands().forEach(Command::execute);
                finalLocations.add(entry.getKey().getOutPutFormat().concat("\n"));
            });

            droneLocations.put(entry.getKey().getName().getValue(), finalLocations);
            LOGGER.info("*** The final position for the drone " + entry.getKey().getName().getValue() +
                    " is " + entry.getKey().getOutPutFormat());
        }
        writeInOutPutFile(droneLocations);
    }

    private static void writeInOutPutFile(Map<String, List<String>> droneLocations){

        for(Map.Entry<String, List<String>> entry : droneLocations.entrySet()){
            FileOutputWriter.writeLinesInOutputFile(entry.getKey(), entry.getValue());
        }
    }

}
