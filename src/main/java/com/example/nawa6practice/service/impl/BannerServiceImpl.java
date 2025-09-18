package com.example.nawa6practice.service.impl;

import com.example.nawa6practice.domain.Banner;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nawa6practice.repository.BannerRepository;
import com.example.nawa6practice.service.BannerService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public List<Banner> gets() {
        return bannerRepository.findAll();
    }

    @Override
    public void update(Long id, String imageUrl, String linkUrl, int displayOrder) {
        Banner banner = bannerRepository.findById(id).get();

        banner.update(imageUrl, linkUrl, displayOrder);
    }

    @Override
    public void delete(Long id) {
        Banner banner = bannerRepository.findById(id).get();

        banner.delete();
    }
}
