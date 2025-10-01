package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.Banner.DeleteBannerReq;
import com.example.nawa6practice.controller.view.Banner.GetBannersRes;
import com.example.nawa6practice.controller.view.Banner.UpdateBannerReq;
import com.example.nawa6practice.domain.Banner;
import com.example.nawa6practice.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banners")
public class BannerController {

    private final BannerService bannerService;

    @GetMapping
    public GetBannersRes gets() {
        List<Banner> banners = bannerService.gets();

        return new GetBannersRes(banners);
    }

    @PostMapping
    public void update(UpdateBannerReq req) {
        bannerService.update(req.getId(), req.getImageUrl(), req.getLinkUrl(), req.getDisplayOrder());
    }

    @PostMapping
    public void delete(DeleteBannerReq req) {
        bannerService.delete(req.getId());
    }
}
