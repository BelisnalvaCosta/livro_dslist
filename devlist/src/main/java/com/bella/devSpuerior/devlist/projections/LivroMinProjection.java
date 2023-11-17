package com.bella.devSpuerior.devlist.projections;

public interface LivroMinProjection {
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}