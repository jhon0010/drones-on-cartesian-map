package com.restaurant.instruction.domain;

import com.restaurant.instruction.domain.command.Command;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Represents one line of the input file with many commands.
 * For example AAAAIAA
 */
@Data
@Builder
public class Instruction {

    private List<Command> commands;

    public boolean validateInstructionStructure(Instruction instruction){
        return true;
    }

}
