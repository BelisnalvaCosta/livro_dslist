package com.bella.devSpuerior.devlist.dto;

import com.bella.devSpuerior.devlist.entities.Livro;
import com.bella.devSpuerior.devlist.projections.LivroMinProjection;

public class LivroMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public LivroMinDTO(Livro entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public LivroMinDTO(LivroMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
