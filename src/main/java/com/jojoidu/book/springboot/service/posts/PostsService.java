package com.jojoidu.book.springboot.service.posts;

import com.jojoidu.book.springboot.domain.posts.PostsRepository;
import com.jojoidu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository pr;
    Logger logger = LoggerFactory.getLogger(PostsService.class);

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        logger.info("서비스도 들어ㅘㅅ슈~~~~~~~~~~~~~~~~~~~~~{}", requestDto.getContent());
        return pr.save(requestDto.toEntity()).getId();
    }
}
