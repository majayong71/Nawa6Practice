package com.example.nawa6practice.controller.view.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateMenuReq {
    private final Long id = 1L;
    private final String name;
    private final int price;
    private final String description;
    private final boolean isMain;
    private final String mainImageUrl;
}
