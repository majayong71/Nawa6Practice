package com.example.nawa6practice.service.impl;

import com.example.nawa6practice.domain.*;
import com.example.nawa6practice.repository.PostRepository;
import com.example.nawa6practice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nawa6practice.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void register(Long userId, PostCategory category, String title, String content, String imageUrl) {
        User user = userRepository.findById(userId).get();

        Post post = new Post(user, title, content, category, imageUrl);

        postRepository.save(post);
    }

    @Override
    public List<Post> search(SearchCategory category, String keyword) {
        return switch (category) {
            case TITLE -> postRepository.searchByTitle(keyword, PostStatus.REGISTERED);
            case CONTENT -> postRepository.searchByContent(keyword, PostStatus.REGISTERED);
            case TITLE_CONTENT -> postRepository.searchByTitleOrContent(keyword, PostStatus.REGISTERED);
        };
    }

    @Override
    public List<Post> gets() {
        return postRepository.findAll();
    }

    @Override
    public Post get(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public void update(Long id, Long userId, PostCategory category, String title, String content, String imageUrl) {
        Post post = postRepository.findById(id).get();

        post.update(userId, title, content, category, imageUrl);
    }

    @Override
    public void delete(Long id, Long userId) {
        Post post = postRepository.findById(id).get();

        post.delete(userId);
    }
}
