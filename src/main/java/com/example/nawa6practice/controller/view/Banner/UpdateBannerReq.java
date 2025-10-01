package com.example.nawa6practice.controller.view.Banner;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateBannerReq {
    private final Long id;
    private final String imageUrl;
    private final String linkUrl;
    private final int displayOrder;
}
