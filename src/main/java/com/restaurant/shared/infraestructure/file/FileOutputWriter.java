package com.restaurant.shared.infraestructure.file;

import org.slf4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class FileOutputWriter {

    private static final String OUTPUT_FILES_PATH = "/home/jhon/drones_output/";
    private static final String FILE_HEADER = "== Reporte de entregas == \n";
    private static final String PREPOSITION_OUTPUT_FILE = "out";
    private static final String OUTPUT_FILE_EXTENSION = ".txt";

    private static final Logger LOGGER = getLogger(FileOutputWriter.class);

    private static String createFile(String fileName){

        String outputFile = OUTPUT_FILES_PATH.concat(fileName);
        try {

            File outPutFile = new File(outputFile);
            if(!outPutFile.createNewFile()) {
                String outputFileRenamed = OUTPUT_FILES_PATH.concat(LocalDateTime.now().toString() + fileName);
                outPutFile.renameTo(new File(outputFileRenamed) );
                createFile(fileName);
            }
            LOGGER.info("The output file ".concat(outputFile).concat(" was created successfully"));
        } catch (IOException ioException){
            LOGGER.error("A problem occurs when try to create the output file");
        }

        return outputFile;
    }

    public static void writeLinesInOutputFile(String fileName, List<String> lines){

        final String pathFile = createFile(PREPOSITION_OUTPUT_FILE.concat(fileName).concat(OUTPUT_FILE_EXTENSION));
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(pathFile));
            writer.write(FILE_HEADER);

            for (String line : lines){
                writer.write(line);
            }

        } catch (IOException ioException) {
            LOGGER.error("An error occurs when try to write in file " + fileName + "\n " +
                    ioException.getMessage());
        } finally {
            try {
                writer.close();
            } catch (IOException ioException) {
                LOGGER.error("An error occurs when try to write in file " + fileName + "\n " +
                        ioException.getMessage());
            }
        }
    }

}
