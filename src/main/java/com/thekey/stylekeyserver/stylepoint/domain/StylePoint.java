package com.thekey.stylekeyserver.stylepoint.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="StylePoint")
public class StylePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stylepoint_id")
    private Long id;

    @Column(name = "stylepoint_title")
    private String title;

    @Column(name = "stylepoint_description")
    private String description;

    @Column(name = "stylepoint_image")
    private String image;

    @Builder
    public StylePoint(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public void update(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
