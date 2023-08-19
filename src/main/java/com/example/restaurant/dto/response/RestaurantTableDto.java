package com.example.restaurant.dto.response;

public class RestaurantTableDto {

  private Long id;
  private String name;
  private Integer seatsNumber;
  private Boolean reservable;
  private String tableArea;

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

  public String getTableArea() {
    return tableArea;
  }

  public void setTableArea(String tableArea) {
    this.tableArea = tableArea;
  }

  public static class Builder {

    private Long id;
    private String name;
    private Integer seatsNumber;
    private Boolean reservable;
    private String tableArea;

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

    public Builder tableArea(String tableArea) {
      this.tableArea = tableArea;
      return this;
    }

    public RestaurantTableDto build() {
      RestaurantTableDto restaurantTableDto = new RestaurantTableDto();
      restaurantTableDto.setId(id);
      restaurantTableDto.setName(name);
      restaurantTableDto.setSeatsNumber(seatsNumber);
      restaurantTableDto.setReservable(reservable);
      restaurantTableDto.setTableArea(tableArea);
      return restaurantTableDto;
    }
  }
}
