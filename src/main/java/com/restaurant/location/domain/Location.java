package com.restaurant.location.domain;

import com.restaurant.location.domain.city.City;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

    private City city;

}
