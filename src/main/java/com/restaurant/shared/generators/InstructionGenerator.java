package com.restaurant.shared.generators;

import com.restaurant.drone.domain.Drone;
import com.restaurant.instruction.domain.Instruction;

public class InstructionGenerator {

    public static Instruction generate(){
        return Instruction.builder()
                .commands(CommandGenerator.generate())
                .build();
    }

    public static Instruction generate(Drone drone){
        return Instruction.builder()
                .commands(CommandGenerator.generate(drone))
                .build();
    }

}
