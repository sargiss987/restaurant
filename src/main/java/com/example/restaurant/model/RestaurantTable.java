package com.example.restaurant.model;

import jakarta.persistence.*;

@Entity
public class RestaurantTable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer seatsNumber;

  private Boolean reservable;

  @ManyToOne
  @JoinColumn(name = "area_id")
  private RestaurantTableArea tableArea;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public RestaurantTableArea getTableArea() {
    return tableArea;
  }

  public void setTableArea(RestaurantTableArea tableArea) {
    this.tableArea = tableArea;
  }

  public static class Builder {

    private Long id;
    private String name;
    private Integer seatsNumber;
    private Boolean reservable;
    private RestaurantTableArea tableArea;

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder seatsNumber(Integer seatsNumber) {
      this.seatsNumber = seatsNumber;
      return this;
    }

    public Builder reservable(Boolean reservable) {
      this.reservable = reservable;
      return this;
    }

    public Builder tableArea(RestaurantTableArea tableArea) {
      this.tableArea = tableArea;
      return this;
    }

    public RestaurantTable build() {
      RestaurantTable restaurantTable = new RestaurantTable();
      restaurantTable.setId(id);
      restaurantTable.setName(name);
      restaurantTable.setSeatsNumber(seatsNumber);
      restaurantTable.setReservable(reservable);
      restaurantTable.setTableArea(tableArea);
      return restaurantTable;
    }
  }
}
