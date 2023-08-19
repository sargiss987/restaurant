package com.example.restaurant.dto.request;

import com.example.restaurant.enums.RestaurantTableAreaType;
import com.example.restaurant.validation.AllowedTableSeatsValues;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddRestaurantTableRequestDto {

  @NotNull
  @Size(min = 2, max = 20, message = "The name must be between 2 and 20 characters")
  private String name;

  @NotNull @AllowedTableSeatsValues private Integer seatsNumber;

  @NotNull private Boolean reservable;

  @NotNull private RestaurantTableAreaType tableArea;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSeatsNumber() {
    return seatsNumber;
  }

  public void setSeatsNumber(Integer seatsNumber) {
    this.seatsNumber = seatsNumber;
  }

  public Boolean getReservable() {
    return reservable;
  }

  public void setReservable(Boolean reservable) {
    this.reservable = reservable;
  }

  public RestaurantTableAreaType getTableArea() {
    return tableArea;
  }

  public void setTableArea(RestaurantTableAreaType tableArea) {
    this.tableArea = tableArea;
  }
}
