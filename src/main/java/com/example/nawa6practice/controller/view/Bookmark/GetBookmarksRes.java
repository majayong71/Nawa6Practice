package com.example.nawa6practice.controller.view.Bookmark;

import com.example.nawa6practice.domain.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetBookmarksRes {
    private final List<BookmarkData> bookmarks;

    public GetBookmarksRes(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks.stream().map(bookmark -> new BookmarkData(
                        bookmark.getUser().getId(), bookmark.getPost().getId()
                )
        ).collect(Collectors.toList());
    }
}
