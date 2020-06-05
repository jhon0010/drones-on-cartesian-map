package com.restaurant.shared.domain;

public enum Orientation {

    N("North"),
    W("West"),
    S("South"),
    E("East");

    private String description;

    Orientation(String description) {
        this.description = description;
    }
}
