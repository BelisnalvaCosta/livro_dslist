package com.bella.devSpuerior.devlist.controller;

import com.bella.devSpuerior.devlist.dto.LivroDTO;
import com.bella.devSpuerior.devlist.dto.LivroMinDTO;
import com.bella.devSpuerior.devlist.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {
    @Autowired
    private LivroService gameService;

    @GetMapping(value = "/{id}")
    public LivroDTO findById(@PathVariable Long id) {
        LivroDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<LivroMinDTO> findAll() {
        List<LivroMinDTO> result = gameService.findAll();
        return result;
    }
}
