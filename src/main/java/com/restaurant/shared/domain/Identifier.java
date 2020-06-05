package com.restaurant.shared.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Encapsulates the logic of generate ids, if you letter want
 * to change the UUID generator  the consumer of this change doesn't care
 */
@Getter
public abstract class Identifier implements Serializable {

    private String value;

    public Identifier() {
        this.value = UUID.randomUUID().toString();
    }
}
