package service.impl;

import domain.Menu;
import domain.MenuStatus;
import domain.Restaurant;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.MenuRepository;
import repository.RestaurantRepository;
import service.MenuService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(Long restaurantId, String name, int price, String description, boolean isMain, String mainImageUrl) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Menu menu = new Menu(restaurant, name, price, description, isMain, mainImageUrl);

        menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAll(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        return menuRepository.findByRestaurantAndStatus(restaurant, MenuStatus.REGISTERED);
    }

    @Override
    public Menu get(Long id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public void update(Long id, String name, int price, String description, boolean isMain, String mainImageUrl) {
        Menu menu = menuRepository.findById(id).get();

        menu.update(name, price, description, isMain, mainImageUrl);
    }

    @Override
    public void delete(Long id) {
        Menu menu = menuRepository.findById(id).get();

        /** 도메인 메서드 delete 를 사용해서 상태를 visible = false 로 변경 **/
        menu.delete();
    }
}
