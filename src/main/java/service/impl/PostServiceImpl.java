package service.impl;

import domain.Post;
import domain.PostCategory;
import domain.SearchCategory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    @Override
    public void register(Long userId, PostCategory category, String title, String content, String imageUrl) {

    }

    @Override
    public List<Post> search(SearchCategory category, String keyword) {
        return List.of();
    }

    @Override
    public List<Post> gets() {
        return List.of();
    }

    @Override
    public Post get(Long id) {
        return null;
    }

    @Override
    public List<Post> getByUserId(Long userId) {
        return List.of();
    }

    @Override
    public void update(Long id, Long userId, PostCategory category, String title, String content, String imageUrl) {

    }

    @Override
    public void delete(Long id, Long userId) {

    }
}
