package com.bella.devSpuerior.devlist.dto;

import com.bella.devSpuerior.devlist.entities.LivroList;

public class LivroListDTO {
    private Long id;
    private String name;

    public LivroListDTO(LivroList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
