package com.restaurant.instruction.domain.command;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

@Data
@Builder
public class Command {

    private CommandType type;

    public boolean isValidCommand(Command command){
        return Arrays.stream(CommandType.values())
                .anyMatch(ct -> command.type.equals(ct));
    }

}
