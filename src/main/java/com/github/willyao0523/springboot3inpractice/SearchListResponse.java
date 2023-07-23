package com.github.willyao0523.springboot3inpractice;

record SearchListResponse(String kind, String etag, String nextPageToken, String prevPageToken, PageInfo pageInfo,
                          SearchResult[] items) {
}
