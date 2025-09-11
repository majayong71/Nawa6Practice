package service.impl;

import domain.Restaurant;
import domain.RestaurantCategory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.RestaurantRepository;
import service.RestaurantService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(String name, RestaurantCategory category, String address, String businessHours,
                         String phoneNumber, String description, String mainImageUrl
    ) {
        Restaurant restaurant = new Restaurant(
                name, category, address, businessHours, phoneNumber, description, mainImageUrl
        );

        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant get(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getByCategory(RestaurantCategory category) {
        return restaurantRepository.findByCategory(category);
    }

    @Override
    public void update(
            Long id, String name, RestaurantCategory category, String address, String businessHours, String phoneNumber,
            String description, String mainImageUrl, boolean visible
    ) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.update(name, category, address, businessHours, phoneNumber, description, mainImageUrl, visible);
    }

    @Override
    public void delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.delete();
    }
}
