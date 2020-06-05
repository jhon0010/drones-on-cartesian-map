package com.restaurant;

import com.restaurant.instruction.application.CommandInvoker;
import com.restaurant.shared.infraestructure.exceptions.InputInstructionFileNotFoundException;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class RestaurantMain {

    private static final Logger LOGGER = getLogger(RestaurantMain.class);

    public static void main(String[] args) {
        LOGGER.info("Starting drone's restaurants delivery ..");
        try {
            new CommandInvoker().start();
        } catch (InputInstructionFileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }

}
