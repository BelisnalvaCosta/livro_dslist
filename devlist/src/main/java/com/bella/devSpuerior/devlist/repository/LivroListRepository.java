package com.bella.devSpuerior.devlist.repository;

import com.bella.devSpuerior.devlist.entities.LivroList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LivroListRepository extends JpaRepository<LivroList, Long> {
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND livro_id = :livroId")
    void updateBelongingPosition(Long listId, Long livroId, Integer newPosition);
}
