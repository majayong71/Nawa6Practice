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


    //ToDo : Repo Query 건들거 있는지 확인하고 작성하기.
    @Override
    public List<Bookmark> gets() {
        return bookmarkRepository.findByStatus(BookmarkStatus.REGISTERED);
    }

    @Override
    public void register(Long userId, Long postId) {
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();

        bookmarkRepository.save(new Bookmark(user, post));
    }

    @Override
    public void delete(Long id, Long userId) {
        User user = userRepository.findById(userId).get();
        Bookmark bookmark = bookmarkRepository.findById(id).get();

        bookmark.delete(user);
    }
}
