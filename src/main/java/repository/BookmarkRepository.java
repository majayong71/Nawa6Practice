package repository;

import domain.Bookmark;
import domain.BookmarkStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findBybookmarkStatus(BookmarkStatus status);
}
