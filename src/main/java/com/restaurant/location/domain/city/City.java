package com.restaurant.location.domain.city;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {

    private CityId id;
    private CityName name;
}
