package com.jojoidu.book.springboot.service.posts;

import com.jojoidu.book.springboot.domain.posts.Posts;
import com.jojoidu.book.springboot.domain.posts.PostsRepository;
import com.jojoidu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoidu.book.springboot.web.dto.PostsResponseDto;
import com.jojoidu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public PostsResponseDto findById(Long id){
        Posts entity = pr.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = pr.findById(id).orElseThrow(
                () ->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return pr.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = pr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        pr.delete(posts);
    }
}
