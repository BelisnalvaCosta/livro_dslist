package com.bella.devSpuerior.devlist.repository;

import com.bella.devSpuerior.devlist.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query(nativeQuery = true, value = """
			SELECT tb_livro.id, tb_livro.title, tb_livro.livro_year AS livroYear, tb_livro.img_url AS imgUrl,
			tb_livro.short_description AS shortDescription, tb_belonging.position
			FROM tb_livro
			INNER JOIN tb_belonging ON tb_livro.id = tb_belonging.livro_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
    List<LivroMinProjection> searchByList(Long listId);
}



