package com.example.restaurant.mapper;

import com.example.restaurant.dto.request.AddRestaurantTableRequestDto;
import com.example.restaurant.dto.request.UpdateRestaurantTableRequestDto;
import com.example.restaurant.dto.response.RestaurantTableDto;
import com.example.restaurant.enums.RestaurantTableAreaType;
import com.example.restaurant.model.RestaurantTable;
import com.example.restaurant.model.RestaurantTableArea;

public final class RestaurantTableMapper {

  private RestaurantTableMapper() {}

  public static RestaurantTable mapToRestaurantTable(
      AddRestaurantTableRequestDto addRestaurantTableRequestDto) {
    return new RestaurantTable.Builder()
        .name(addRestaurantTableRequestDto.getName())
        .seatsNumber(addRestaurantTableRequestDto.getSeatsNumber())
        .reservable(addRestaurantTableRequestDto.getReservable())
        .tableArea(mapToRestaurantTableArea(addRestaurantTableRequestDto.getTableArea()))
        .build();
  }

  public static RestaurantTableDto mapToRestaurantTableDto(RestaurantTable restaurantTable) {
    return new RestaurantTableDto.Builder()
        .id(restaurantTable.getId())
        .name(restaurantTable.getName())
        .seatsNumber(restaurantTable.getSeatsNumber())
        .reservable(restaurantTable.getReservable())
        .tableArea(restaurantTable.getTableArea().getName())
        .build();
  }

  public static RestaurantTable mapToRestaurantTable(
      RestaurantTable restaurantTable,
      UpdateRestaurantTableRequestDto updateRestaurantTableRequestDto) {

    if (updateRestaurantTableRequestDto.getName() != null) {
      restaurantTable.setName(updateRestaurantTableRequestDto.getName());
    }

    if (updateRestaurantTableRequestDto.getSeatsNumber() != null) {
      restaurantTable.setSeatsNumber(updateRestaurantTableRequestDto.getSeatsNumber());
    }

    if (updateRestaurantTableRequestDto.getReservable() != null) {
      restaurantTable.setReservable(updateRestaurantTableRequestDto.getReservable());
    }

    if (updateRestaurantTableRequestDto.getTableArea() != null) {
      restaurantTable.setTableArea(
          mapToRestaurantTableArea(updateRestaurantTableRequestDto.getTableArea()));
    }

    return restaurantTable;
  }

  private static RestaurantTableArea mapToRestaurantTableArea(RestaurantTableAreaType tableArea) {
    switch (tableArea) {
      case OUTDOOR -> {
        return RestaurantTableArea.isOutdoor();
      }
      case TERRACE -> {
        return RestaurantTableArea.isTerrace();
      }
      case COUNTER -> {
        return RestaurantTableArea.isCounter();
      }
      default -> {
        return RestaurantTableArea.isIndoor();
      }
    }
  }
}
