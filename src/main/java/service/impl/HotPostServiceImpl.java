package service.impl;

import domain.HotPost;
import domain.HotPostCategory;
import domain.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.HotPostRepository;
import repository.PostRepository;
import service.HotPostService;

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
    public List<HotPost> gets() {
        return hotPostRepository.findAll();
    }

    //
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
