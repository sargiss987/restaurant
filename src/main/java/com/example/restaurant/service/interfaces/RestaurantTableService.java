package com.example.restaurant.service.interfaces;

import com.example.restaurant.dto.request.AddRestaurantTableRequestDto;
import com.example.restaurant.dto.request.UpdateRestaurantTableRequestDto;
import com.example.restaurant.model.RestaurantTable;
import java.util.List;
import java.util.Optional;

public interface RestaurantTableService {

    RestaurantTable addNewTable(AddRestaurantTableRequestDto addRestaurantTableRequestDto);

    List<RestaurantTable> getAllTables();

    Optional<RestaurantTable> getTableById(Long id);

    Optional<RestaurantTable> updateTable(UpdateRestaurantTableRequestDto updateRestaurantTableRequestDto);

    void deleteTable(Long id);
}
