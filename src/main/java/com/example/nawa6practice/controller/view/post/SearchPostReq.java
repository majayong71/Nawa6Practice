package com.example.nawa6practice.controller.view.post;

import com.example.nawa6practice.domain.SearchCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchPostReq {
    private final SearchCategory searchCategory;
    private final String keyword;
}
