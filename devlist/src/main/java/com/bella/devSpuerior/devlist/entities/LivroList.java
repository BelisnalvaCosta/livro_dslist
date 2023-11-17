package com.bella.devSpuerior.devlist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_livro_list")
public class LivroList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public LivroList() {
    }

    public LivroList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LivroList other = (LivroList) obj;
        return Objects.equals(id, other.id);
    }
}
