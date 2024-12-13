package com.busanit501.kimdh.repository.search;

import com.busanit501.kimdh.domain.Food;
import com.busanit501.kimdh.domain.QFood;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FoodSearchImpl extends QuerydslRepositorySupport implements FoodSearch {
    public FoodSearchImpl() {
        super(Food.class);
    }
    //쿼리 스트링
    @Override
    public Page<Food> search(Pageable pageable) {
        QFood qFood = QFood.food;
        JPQLQuery<Food> query = from(qFood);
        query.where(qFood.fname.contains("3"));
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(qFood.fname.contains("3"));
        booleanBuilder.or(qFood.fmeteral.contains("7"));
        query.where(booleanBuilder);

        this.getQuerydsl().applyPagination(pageable, query);

        List<Food> foods = query.fetch();
        long total = query.fetchCount();

        return null;
    }

    @Override
    public Page<Food> searchAll(String[] types, String keyword, Pageable pageable) {
        QFood qFood = QFood.food;
        JPQLQuery<Food> query = from(qFood);
        if(types != null && types.length > 0 && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for(String type : types) {
                switch(type) {
                    case "t":
                        booleanBuilder.or(qFood.fname.contains(keyword));
                    case "c":
                        booleanBuilder.or(qFood.fmeteral.contains(keyword));
                    case "w":
                        booleanBuilder.or(qFood.writer.contains(keyword));
                }//switch
            }//for
            query.where(booleanBuilder);
        }//if
        query.where(qFood.id.gt(0L));


        this.getQuerydsl().applyPagination(pageable, query);
        List<Food> foods = query.fetch();
        long total = query.fetchCount();

        Page<Food> food1 = new PageImpl<Food>(foods, pageable, total);

        return food1;
    }
}
