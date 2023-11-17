package com.bella.devSpuerior.devlist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class BelongingPK {
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private LivroList list;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LivroList getList() {
        return list;
    }

    public void setList(LivroList list) {
        this.list = list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, list);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        return Objects.equals(livro, other.livro) && Objects.equals(list, other.list);
    }
}