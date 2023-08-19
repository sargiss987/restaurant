package com.example.restaurant.model;

import com.example.restaurant.enums.RestaurantTableAreaType;
import jakarta.persistence.*;

@Entity
public class RestaurantTableArea {

  @Id private Long id;

  private String name;

  public RestaurantTableArea(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public RestaurantTableArea() {}

  public static RestaurantTableArea isIndoor(){
    return new RestaurantTableArea(1L, RestaurantTableAreaType.INDOOR.getName());
  }

  public static RestaurantTableArea isOutdoor(){
    return new RestaurantTableArea(2L, RestaurantTableAreaType.OUTDOOR.getName());
  }

  public static RestaurantTableArea isTerrace(){
    return new RestaurantTableArea(3L, RestaurantTableAreaType.TERRACE.getName());
  }

  public static RestaurantTableArea isCounter(){
    return new RestaurantTableArea(4L, RestaurantTableAreaType.COUNTER.getName());
  }

  public String getName() {
    return name;
  }
}
