package com.restaurant.location.domain;

import com.restaurant.location.domain.city.City;
import lombok.Builder;
import lombok.Data;

/**
 * For future extension of Regions, different cities etc.
 */
@Data
@Builder
public class Location {

    private City city;

}
