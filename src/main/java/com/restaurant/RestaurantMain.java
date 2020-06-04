package com.restaurant;

import com.restaurant.drone.domain.Drone;
import com.restaurant.instruction.domain.command.Command;
import com.restaurant.instruction.domain.command.CommandType;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class RestaurantMain {

    private static final Logger LOGGER = getLogger(RestaurantMain.class);

    public static void main(String[] args) {
        LOGGER.info("Starting drone's restaurants delivery ..");

        Command c = Command.builder().type(CommandType.FORWARD).build();

    }
}
