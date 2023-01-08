package com.jojoidu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

//import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository pr;

    @After
    public void cleanup(){
        pr.deleteAll();
    }

    @Test
    public void posts_get(){
        String title = "테스트 게시글";
        String content = "테스트 본문입니다.";
        
        pr.save(Posts.builder()
                .title(title)
                .content(content)
                .author("유제혁")
                .build());

        List<Posts> postsList = pr.findAll();
        
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}