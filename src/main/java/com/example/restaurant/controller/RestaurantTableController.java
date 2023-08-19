package com.example.restaurant.controller;

import com.example.restaurant.dto.request.AddRestaurantTableRequestDto;
import com.example.restaurant.dto.request.UpdateRestaurantTableRequestDto;
import com.example.restaurant.dto.response.RestaurantTableDto;
import com.example.restaurant.mapper.RestaurantTableListMapper;
import com.example.restaurant.mapper.RestaurantTableMapper;
import com.example.restaurant.service.interfaces.RestaurantTableService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurant-table")
public class RestaurantTableController {

  private final RestaurantTableService restaurantTableService;

  public RestaurantTableController(RestaurantTableService restaurantTableService) {
    this.restaurantTableService = restaurantTableService;
  }

  @GetMapping
  public ResponseEntity<List<RestaurantTableDto>> getAllTables() {

    return ResponseEntity.ok(
        RestaurantTableListMapper.mapToListOfRestaurantTableDto(
            restaurantTableService.getAllTables()));
  }

  @GetMapping("{id}")
  public ResponseEntity<RestaurantTableDto> getTableById(@PathVariable Long id) {

    return restaurantTableService
        .getTableById(id)
        .map(table -> ResponseEntity.ok(RestaurantTableMapper.mapToRestaurantTableDto(table)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<RestaurantTableDto> addNewTable(
      @RequestBody @Valid AddRestaurantTableRequestDto addRestaurantTableRequestDto) {

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            RestaurantTableMapper.mapToRestaurantTableDto(
                restaurantTableService.addNewTable(addRestaurantTableRequestDto)));
  }

  @PutMapping
  public ResponseEntity<RestaurantTableDto> updateTable(
      @RequestBody @Valid UpdateRestaurantTableRequestDto updateRestaurantTableRequestDto) {

    return restaurantTableService
        .updateTable(updateRestaurantTableRequestDto)
        .map(table -> ResponseEntity.ok(RestaurantTableMapper.mapToRestaurantTableDto(table)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
    restaurantTableService.deleteTable(id);
    return ResponseEntity.ok().build();
  }
}
