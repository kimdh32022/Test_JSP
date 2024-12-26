package com.busanit501.kimdh.FoodTest1.repository;

import com.busanit501.kimdh.domain.Food;
import com.busanit501.kimdh.domain.Reply;
import com.busanit501.kimdh.repository.FoodRepository;
import com.busanit501.kimdh.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyRepositorytest {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void testInsertMany() {
        // 댓글을 작성 하려면, 부모 게시글 번호가 필요,
        // 각자 데이터베이스에 따라서, 다르므로 꼭 확인하고, 작업.
        Long id = 200L;

        IntStream.range(1, 101).forEach(i -> {
            Food food = Food.builder().id(id).build();
            Reply reply = Reply.builder()
                    .food(food)
                    .text("샘플 댓글" + i)
                    .replyer("샘플 작성자" + i)
                    .build();

            replyRepository.save(reply);
        });
    }
}
