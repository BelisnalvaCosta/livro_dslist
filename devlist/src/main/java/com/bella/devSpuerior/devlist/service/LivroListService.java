package com.bella.devSpuerior.devlist.service;

import com.bella.devSpuerior.devlist.dto.LivroListDTO;
import com.bella.devSpuerior.devlist.entities.LivroList;
import com.bella.devSpuerior.devlist.projections.LivroMinProjection;
import com.bella.devSpuerior.devlist.repository.LivroListRepository;
import com.bella.devSpuerior.devlist.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroListService {
    @Autowired
    private LivroListRepository livroListRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional(readOnly = true)
    public List<LivroListDTO> findAll() {
        List<LivroList> result = livroListRepository.findAll();
        return result.stream().map(LivroListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<LivroMinProjection> list = livroRepository.searchByList(listId);

        LivroMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            livroListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

    @Transactional(readOnly = true)
    public LivroListDTO findById(Long id) {
        LivroList entity = livroListRepository.findById(id).get();
        return new LivroListDTO(entity);
    }
}