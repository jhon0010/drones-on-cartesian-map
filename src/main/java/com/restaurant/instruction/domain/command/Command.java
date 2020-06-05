package com.restaurant.instruction.domain.command;

@FunctionalInterface
public interface Command {
    void execute();
}
