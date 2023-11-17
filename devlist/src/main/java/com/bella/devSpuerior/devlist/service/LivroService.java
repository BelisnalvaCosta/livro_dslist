package com.bella.devSpuerior.devlist.service;

import com.bella.devSpuerior.devlist.dto.LivroDTO;
import com.bella.devSpuerior.devlist.dto.LivroMinDTO;
import com.bella.devSpuerior.devlist.entities.Livro;
import com.bella.devSpuerior.devlist.projections.LivroMinProjection;
import com.bella.devSpuerior.devlist.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Transactional(readOnly = true)
    public LivroDTO findById(@PathVariable Long listId) {
        Livro result = livroRepository.findById(listId).get();
        return new LivroDTO(result);
    }

    @Transactional(readOnly = true)
    public List<LivroMinDTO> findAll() {
        List<Livro> result = livroRepository.findAll();
        return result.stream().map(LivroMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroMinDTO> findByLivroList(Long listId) {
        List<LivroMinProjection> games = livroRepository.searchByList(listId);
        return games.stream().map(LivroMinDTO::new).toList();
    }
}