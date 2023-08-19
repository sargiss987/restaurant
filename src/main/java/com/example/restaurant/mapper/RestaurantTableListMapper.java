package com.example.restaurant.mapper;

import com.example.restaurant.dto.response.RestaurantTableDto;
import com.example.restaurant.model.RestaurantTable;
import java.util.List;

public final class RestaurantTableListMapper {

  private RestaurantTableListMapper() {}

  public static List<RestaurantTableDto> mapToListOfRestaurantTableDto(
      List<RestaurantTable> restaurantTableList) {
    return restaurantTableList.stream()
        .map(RestaurantTableMapper::mapToRestaurantTableDto)
        .toList();
  }
}
