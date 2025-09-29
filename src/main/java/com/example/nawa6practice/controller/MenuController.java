package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.menu.*;
import com.example.nawa6practice.domain.Menu;
import com.example.nawa6practice.service.MenuService;
import com.example.nawa6practice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterMenuReq req) {
        menuService.register(
                req.getRestaurantId(), req.getName(), req.getPrice(), req.getDescription(), req.isMain(),
                req.getMainImageUrl()
        );
    }

    @GetMapping()
    public GetMenusRes getAll(@RequestParam Long restaurantId) {
        List<Menu> menus = menuService.gets(restaurantId);

        return new GetMenusRes(menus);
    }

    @GetMapping("/{id}")
    public GetMenuRes get(@PathVariable Long id) {
        Menu menu = menuService.get(id);

        return new GetMenuRes(menu.getName(), menu.getPrice(), menu.getDescription(), menu.isMain(),
                menu.getImageUrl());
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateMenuReq req) {
        menuService.update(
                req.getId(), req.getName(), req.getPrice(), req.getDescription(), req.isMain(),
                req.getMainImageUrl()
        );
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteMenuReq req) {
        menuService.delete(req.getId());
    }
}
