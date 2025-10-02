package com.example.nawa6practice.service.impl;

import com.example.nawa6practice.domain.HotPost;
import com.example.nawa6practice.domain.HotPostCategory;
import com.example.nawa6practice.domain.HotPostStatus;
import com.example.nawa6practice.domain.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nawa6practice.repository.HotPostRepository;
import com.example.nawa6practice.repository.PostRepository;
import com.example.nawa6practice.service.HotPostService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HotPostServiceImpl implements HotPostService {

    private final HotPostRepository hotPostRepository;
    private final PostRepository postRepository;

    @Override
    public void register(Long postId, LocalDate date, int rank, HotPostCategory category) {
        Post post = postRepository.findById(postId).get();

        HotPost hotPost = new HotPost(post, date, rank, category);

        hotPostRepository.save(hotPost);
    }

    @Override
    public List<HotPost> gets(HotPostCategory category, LocalDate date) {
        return hotPostRepository.findByCategoryAndDate(category, date, HotPostStatus.REGISTERED);
    }

    @Override
    public void update(Long id, Long postId, LocalDate date, int rank, HotPostCategory hotPostCategory) {
        Post post = postRepository.findById(postId).get();
        HotPost hotPost = hotPostRepository.findById(id).get();

        hotPost.update(post, date, rank, hotPostCategory);
    }

    @Override
    public void delete(Long id) {
        HotPost hotPost = hotPostRepository.findById(id).get();

        hotPost.deleted();
    }
}
