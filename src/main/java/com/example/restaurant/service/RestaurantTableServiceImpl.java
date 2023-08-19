package com.example.restaurant.service;

import com.example.restaurant.dto.request.UpdateRestaurantTableRequestDto;
import com.example.restaurant.mapper.RestaurantTableMapper;
import com.example.restaurant.dto.request.AddRestaurantTableRequestDto;
import com.example.restaurant.model.RestaurantTable;
import com.example.restaurant.repository.RestaurantTableServiceRepository;
import com.example.restaurant.service.interfaces.RestaurantTableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

  private final RestaurantTableServiceRepository restaurantTableServiceRepository;

  public RestaurantTableServiceImpl(
      RestaurantTableServiceRepository restaurantTableServiceRepository) {
    this.restaurantTableServiceRepository = restaurantTableServiceRepository;
  }

  @Override
  public List<RestaurantTable> getAllTables() {
    return restaurantTableServiceRepository.findAll();
  }

  @Override
  public Optional<RestaurantTable> getTableById(Long id) {
    return restaurantTableServiceRepository.findById(id);
  }

  @Override
  public RestaurantTable addNewTable(AddRestaurantTableRequestDto addRestaurantTableRequestDto) {
    return restaurantTableServiceRepository.save(
        RestaurantTableMapper.mapToRestaurantTable(addRestaurantTableRequestDto));
  }

  @Override
  public Optional<RestaurantTable> updateTable(
      UpdateRestaurantTableRequestDto updateRestaurantTableRequestDto) {
   return restaurantTableServiceRepository
           .findById(updateRestaurantTableRequestDto.getId()).map(restaurantTable -> restaurantTableServiceRepository.save(
                   RestaurantTableMapper.mapToRestaurantTable(restaurantTable, updateRestaurantTableRequestDto)));

  }

  @Override
  public void deleteTable(Long id) {
    restaurantTableServiceRepository.deleteById(id);
  }
}
