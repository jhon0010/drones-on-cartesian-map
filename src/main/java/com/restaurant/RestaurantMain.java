package com.restaurant;

import com.restaurant.instruction.domain.Instruction;
import com.restaurant.instruction.domain.command.Command;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Also acts as a invoker of the commands.
 */
public class RestaurantMain {

    private static final Logger LOGGER = getLogger(RestaurantMain.class);
    private List<Instruction> instruction;

    public static void main(String[] args) {
        LOGGER.info("Starting drone's restaurants delivery ..");
    }
}
