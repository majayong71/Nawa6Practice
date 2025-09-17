package service.impl;

import domain.Comment;
import domain.CommentStatus;
import domain.Post;
import domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CommentRepository;
import repository.PostRepository;
import repository.UserRepository;
import service.CommentService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void register(Long userId, Long postId, String content, String imageUrl) {
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();

        Comment comment = new Comment(user, post, content, imageUrl);

        commentRepository.save(comment);
    }

    @Override
    public List<Comment> gets(Long postId) {
        Post post = postRepository.findById(postId).get();

        return commentRepository.findByPostAndStatus(post, CommentStatus.REGISTERED);
    }

    // 체크 받아보기
    @Override
    public void update(Long id, Long userId, String content, String imageUrl) {
        Comment comment = commentRepository.findById(id).get();

        comment.update(userId, content, imageUrl);
    }

    @Override
    public void delete(Long id, Long userId) {
        Comment comment = commentRepository.findById(id).get();

        comment.deleted(userId);
    }
}
