package com.RodriSolution.dslist.Services;

import com.RodriSolution.dslist.dto.GameDTO;
import com.RodriSolution.dslist.dto.GameListDTO;
import com.RodriSolution.dslist.dto.GameMinDTO;
import com.RodriSolution.dslist.entities.Game;
import com.RodriSolution.dslist.entities.GameList;
import com.RodriSolution.dslist.repositories.GameListRepository;
import com.RodriSolution.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
        
    }
}

