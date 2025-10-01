package com.example.nawa6practice.controller.view.Banner;

import com.example.nawa6practice.domain.Banner;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetBannersRes {
    private final List<BannerData> banners;

    public GetBannersRes(List<Banner> banners) {
        this.banners = banners.stream().map(banner -> new BannerData(
                        banner.getImageUrl(), banner.getLinkUrl()
                )
        ).collect(Collectors.toList());
    }
}
