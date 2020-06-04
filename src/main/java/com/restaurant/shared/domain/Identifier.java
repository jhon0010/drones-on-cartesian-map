package com.restaurant.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Encapsulates the logic of generate ids, if you letter want
 * to change the UUID generator  the consumer of this change doesn't care
 */
public abstract class Identifier implements Serializable {

    private String value;

    public Identifier(String value) {

        this.value = UUID.fromString(value).toString();;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
