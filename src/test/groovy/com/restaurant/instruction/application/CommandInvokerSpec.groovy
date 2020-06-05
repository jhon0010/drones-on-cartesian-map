package com.restaurant.instruction.application

import com.restaurant.drone.domain.Drone
import com.restaurant.drone.domain.location.DroneLocation
import com.restaurant.instruction.domain.Instruction
import com.restaurant.shared.domain.Orientation
import com.restaurant.shared.generators.DroneGenerator
import com.restaurant.shared.generators.InstructionGenerator
import spock.lang.Specification


class CommandInvokerSpec extends Specification {

    def 'Should execute a instruction (list of commands) and change the location of the drone'() {

        given: 'A drone instance with initial location (0,0,N)'
            def drone = DroneGenerator.generate()
        and: 'A list of instructions for the above drone'
            def instructions = InstructionGenerator.generate(drone)
        and:'An expected drone location after commands execution'
            def expectedDroneLocation = expectedDroneLocationAfterCommands()
        when: 'The commands in the instruction will be executed'

            Map<Drone, List<Instruction>> droneInstructions =
                    new HashMap(){{
                        put(drone, Arrays.asList(instructions))
                    }}
            CommandInvoker.executeDroneInstructions(droneInstructions)
        then: 'The state of the drone change as we expected'
            expectedDroneLocation == drone.location
    }

    private static DroneLocation expectedDroneLocationAfterCommands(){

        return DroneLocation.builder()
                .orientation(Orientation.W)
                .x(-2)
                .y(4)
                .build()
    }

}
