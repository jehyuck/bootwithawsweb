package com.jojoidu.book.springboot.dto;

import com.jojoidu.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombookTest(){
        String name ="test";
        int amount = 10000;

       HelloResponseDto dto = new HelloResponseDto(name, amount);

       assertThat(dto.getName()).isEqualTo(name);
       assertThat(dto.getAmount()).isEqualTo(amount);
    }
}