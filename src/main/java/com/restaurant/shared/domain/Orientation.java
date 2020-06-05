package com.restaurant.shared.domain;

public enum Orientation {

    N ("North"),
    W ("West"),
    S ("South"),
    E ("East");

    public String name;

    Orientation(String name) {
        this.name = name;
    }
}
