package com.jojoidu.book.springboot.web;

import com.jojoidu.book.springboot.service.posts.PostsService;
import com.jojoidu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService ps;
    Logger logger = LoggerFactory.getLogger(PostsApiController.class);
    @PostMapping("/api/v1/posts")
    public Long save(@RequestParam PostsSaveRequestDto requestDto){
        logger.info("들어왔슈~~~~~~~~~~~~~~~~~~~~~{}", requestDto.getContent());
        System.out.println("도대체 왜!!!!!!!!!!!!!!!!!!");
        return ps.save(requestDto);
    }
}
