package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.Bookmark.DeleteBookmarkReq;
import com.example.nawa6practice.controller.view.Bookmark.GetBookmarksRes;
import com.example.nawa6practice.controller.view.Bookmark.RegisterBookmarkReq;
import com.example.nawa6practice.domain.Bookmark;
import com.example.nawa6practice.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @PostMapping("/register")
    public void register(RegisterBookmarkReq req) {
        bookmarkService.register(req.getUserId(), req.getPostId());
    }

    @GetMapping
    public GetBookmarksRes gets(@RequestParam Long userId) {
        List<Bookmark> bookmarks = bookmarkService.gets(userId);

        return new GetBookmarksRes(bookmarks);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteBookmarkReq req) {
        bookmarkService.delete(req.getId(),req.getUserId());
    }
}

