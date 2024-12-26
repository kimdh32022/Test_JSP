package com.busanit501.kimdh.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "FoodReply", indexes = {
        @Index(name = "idx_FoodReply_food_id", columnList = "food_id")
})
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class food_Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Food food;

    private String text;

    private String replyer;

    public void changeFood(Food food) {
        this.food = food;
    }

    public void changeReplyTextReplyer(String text, String replyer) {
        this.text = text;
        this.replyer = replyer;
    }
}
