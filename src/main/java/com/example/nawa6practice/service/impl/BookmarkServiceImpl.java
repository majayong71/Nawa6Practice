package com.example.nawa6practice.service.impl;

import com.example.nawa6practice.domain.Bookmark;
import com.example.nawa6practice.domain.BookmarkStatus;
import com.example.nawa6practice.domain.Post;
import com.example.nawa6practice.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nawa6practice.repository.BookmarkRepository;
import com.example.nawa6practice.repository.PostRepository;
import com.example.nawa6practice.repository.UserRepository;
import com.example.nawa6practice.service.BookmarkService;

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
        return bookmarkRepository.findByStatus(BookmarkStatus.REGISTERED);
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
