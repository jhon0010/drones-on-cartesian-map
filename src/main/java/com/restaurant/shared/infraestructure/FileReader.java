package com.restaurant.shared.infraestructure;

import com.restaurant.shared.infraestructure.exceptions.InputInstructionFileNotFoundException;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Utility for read files from the resources location.
 */
public class FileReader {

    private static final Logger LOGGER = getLogger(FileReader.class);
    private static final String PATH_RESOURCES = "/home/jhon/workspace/drones-on-cartesian-map/src/main/resources";

    public static Map<String, List<String>> readInputInstructionFiles() throws InputInstructionFileNotFoundException {

        Map<String, List<String>> fileInstructions = new HashMap<>();

        try {
            final List<String> inputFiles = getListOfFiles(PATH_RESOURCES);

            for (String fileName : inputFiles) {
                fileInstructions.putIfAbsent(fileName, getLinesFromFile(fileName));
            }
        } catch (FileNotFoundException fne) {
            throw new InputInstructionFileNotFoundException("The input file was not found " + fne.getMessage());
        }

        return fileInstructions;
    }

    private static List<String> getLinesFromFile(String fileName) throws FileNotFoundException {

        List<String> lines = new ArrayList<>();
        ClassLoader classLoader = FileReader.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        LOGGER.info("File found = " + file.getName());

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lines.add(data);
                LOGGER.info(data);
            }
        }
        return lines;
    }


    private static List<String> getListOfFiles(String directory) {
        return Stream.of(new File(directory).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
    }

}


