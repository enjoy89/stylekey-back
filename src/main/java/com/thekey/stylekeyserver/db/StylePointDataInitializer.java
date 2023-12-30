package com.thekey.stylekeyserver.db;

import com.thekey.stylekeyserver.stylepoint.domain.StylePoint;
import com.thekey.stylekeyserver.stylepoint.domain.StylePointRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StylePointDataInitializer {

    private final StylePointRepository stylePointRepository;

    @PostConstruct
    public void init() {
        StylePoint stylePoint_1 = StylePoint.builder()
                .title("Unique")
                .description("변화하는 트렌드를 반영하여 평범하지 않고 개성있는 디테일을 추구하는 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%8B%E1%85%B2%E1%84%82%E1%85%B5%E1%84%8F%E1%85%B3%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png")
                .build();
        stylePointRepository.save(stylePoint_1);

        StylePoint stylePoint_2 = StylePoint.builder()
                .title("Street")
                .description("격식을 갖추지 않고 길거리에서 편하게 입을 수 있는 힙한 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%E1%84%85%E1%85%B5%E1%86%BA%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png")
                .build();
        stylePointRepository.save(stylePoint_2);

        StylePoint stylePoint_3 = StylePoint.builder()
                .title("Modern")
                .description("장식적인 것 없이 깔끔하고 심플하며 직선적인 실루엣을 추구하는 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%86%E1%85%A9%E1%84%83%E1%85%A5%E1%86%AB%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png")
                .build();
        stylePointRepository.save(stylePoint_3);

        StylePoint stylePoint_4 = StylePoint.builder()
                .title("Normal")
                .description("일상적이고 평범한 착장이 무난하지 않도록 센스있는 포인트가 들어간 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%82%E1%85%A9%E1%84%86%E1%85%A5%E1%86%AF%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png")
                .build();
        stylePointRepository.save(stylePoint_4);

        StylePoint stylePoint_5 = StylePoint.builder()
                .title("Lovely")
                .description("사랑스러운 소녀같이 귀엽고 로맨틱하면서 여성스러운 무드를 강조한 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%85%E1%85%A5%E1%84%87%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.jpg")
                .build();
        stylePointRepository.save(stylePoint_5);

        StylePoint stylePoint_6 = StylePoint.builder()
                .title("Retro")
                .description("1990-2000년대의 감성을 재해석하여 오래된 듯한 멋진 느낌이 드는 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%85%E1%85%A6%E1%84%90%E1%85%B3%E1%84%85%E1%85%A9%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.jpg")
                .build();
        stylePointRepository.save(stylePoint_6);

        StylePoint stylePoint_7 = StylePoint.builder()
                .title("Glam")
                .description("섹시함이 강조되는 화려하고 여성스러운 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%80%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%86%B7%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png")
                .build();
        stylePointRepository.save(stylePoint_7);

        StylePoint stylePoint_8 = StylePoint.builder()
                .title("Active")
                .description("스포츠웨어와 일상복의 경계를 허물고 활동적인 이미지를 표현하는 스타일")
                .image("https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%8B%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B5%E1%84%87%E1%85%B3%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png")
                .build();
        stylePointRepository.save(stylePoint_8);
    }

}
