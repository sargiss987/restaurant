package com.example.restaurant.enums;

public enum RestaurantTableAreaType {
  INDOOR("Indoor"),
  OUTDOOR("Outdoor"),
  TERRACE("Terrace"),
  COUNTER("Counter");

  private final String name;

  RestaurantTableAreaType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
