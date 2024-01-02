package com.thekey.stylekeyserver.brand.dto;

import com.thekey.stylekeyserver.brand.domain.Brand;
import com.thekey.stylekeyserver.stylepoint.domain.StylePoint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBrandRequestDto {
    private String title;
    private String title_eng;
    private String description;
    private String site_url;
    private String image;
    private Long stylePointId;

    @Builder
    public CreateBrandRequestDto(String title, String title_eng, String description, String site_url, String image,
                                 Long stylePointId) {
        this.title = title;
        this.title_eng = title_eng;
        this.description = description;
        this.site_url = site_url;
        this.image = image;
        this.stylePointId = stylePointId;
    }

    public Brand toEntity(StylePoint stylePoint) {
        return Brand.builder()
                .title(this.title)
                .title_eng(this.title_eng)
                .description(this.description)
                .site_url(this.site_url)
                .image(this.image)
                .stylePoint(stylePoint)
                .build();
    }
}
