package com.restaurant.instruction.domain.command;

public enum CommandType {

    FORWARD('A'),
    TURN_LEFT('I'),
    TURN_RIGHT('D')
    ;

    private char command;

    CommandType(char command) {
        this.command = command;
    }
}
