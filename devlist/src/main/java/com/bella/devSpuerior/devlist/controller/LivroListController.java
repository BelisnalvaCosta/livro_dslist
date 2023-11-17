package com.bella.devSpuerior.devlist.controller;

import com.bella.devSpuerior.devlist.dto.LivroListDTO;
import com.bella.devSpuerior.devlist.dto.LivroMinDTO;
import com.bella.devSpuerior.devlist.dto.ReplacementDTO;
import com.bella.devSpuerior.devlist.service.LivroListService;
import com.bella.devSpuerior.devlist.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class LivroListController {
    @Autowired
    private LivroListService livroListService;

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public LivroListDTO findById(@PathVariable Long id) {
        LivroListDTO result = livroListService.findById(id);
        return result;
    }

    @GetMapping
    public List<LivroListDTO> findAll() {
        List<LivroListDTO> result = livroListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<LivroMinDTO> findGames(@PathVariable Long listId) {
        List<LivroMinDTO> result = livroService.findByLivroList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        livroListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}