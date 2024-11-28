package com.busanit501.helloworld.Food.Utill;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtill {
    INSTANCE;
    // 외뷔 라이브러리 모델 맵퍼를 가지고옴
    private ModelMapper modelMapper;

    MapperUtill() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration() .setFieldMatchingEnabled(true)
                //VO <-> DTO 멤버의 일치성 여부를 확인하는 설정
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                //타입이 정확하게 일치하는지 여부를 꼼꼼하게 엄격하게 검사하는 설정
                .setMatchingStrategy(MatchingStrategies.STRICT);
                //멤버 접근시 private 접근 지정자에 접근 가능하게 하는 설정
    }

    public ModelMapper getMap() {
        return modelMapper;

    }
}
