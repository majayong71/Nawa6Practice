package com.example.nawa6practice.controller;

import com.example.nawa6practice.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banners")
public class BannerController {

    private final BannerService bannerService;
}
