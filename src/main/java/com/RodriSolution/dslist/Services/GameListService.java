package com.RodriSolution.dslist.Services;

import com.RodriSolution.dslist.dto.GameDTO;
import com.RodriSolution.dslist.dto.GameListDTO;
import com.RodriSolution.dslist.dto.GameMinDTO;
import com.RodriSolution.dslist.entities.Game;
import com.RodriSolution.dslist.entities.GameList;
import com.RodriSolution.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
        
    }

    @Transactional
    public void move(long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}

