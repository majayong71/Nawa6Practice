package repository;

import domain.Comment;
import domain.CommentStatus;
import domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostAndStatus(Post post, CommentStatus status);
}
