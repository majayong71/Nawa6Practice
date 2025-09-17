package service.impl;

import domain.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.BookmarkRepository;
import repository.PostRepository;
import repository.UserRepository;
import service.BookmarkService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public List<Bookmark> gets() {
        return bookmarkRepository.findBybookmarkStatus(BookmarkStatus.REGISTERED);
    }

    @Override
    public void register(Long userId, Long postId) {
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();

        Bookmark bookmark = new Bookmark(user, post);

        bookmarkRepository.save(bookmark);
    }

    @Override
    public void delete(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id).get();

        bookmark.delete();
    }
}
