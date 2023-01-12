package com.jojoidu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

//import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@EnableJpaAuditing
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

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2023,1,1,0,0,0);
        pr.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postList = pr.findAll();

        //then
        Posts posts= postList.get(0);
        System.out.println(">>>>>>>>>>>>>> cretatedDate = "+ posts.getCreatedDate()
                +"  modifedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}