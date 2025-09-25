package com.example.nawa6practice.controller.view.menu;

import com.example.nawa6practice.domain.Menu;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetMenusRes {
    private final List<MenuData> menus;

    public GetMenusRes(List<Menu> menus) {
        this.menus = menus.stream().map(menu -> new MenuData(
                        menu.getId(), menu.getRestaurant().getId(), menu.getName(), menu.getPrice(),
                        menu.getDescription(), menu.isMain(), menu.getImageUrl()
                )
        ).collect(Collectors.toList());
    }
}
