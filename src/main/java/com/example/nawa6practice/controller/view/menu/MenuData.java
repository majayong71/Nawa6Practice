package com.example.nawa6practice.controller.view.menu;

import com.example.nawa6practice.domain.MenuStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuData {
    private final Long id;
    private final Long restaurantId;
    private final String name;
    private final int price;
    private final String description;
    private final boolean isMain;
    private final String imageUrl;
}
