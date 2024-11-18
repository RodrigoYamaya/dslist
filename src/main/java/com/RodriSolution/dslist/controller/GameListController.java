package com.RodriSolution.dslist.controller;

import com.RodriSolution.dslist.Services.GameListService;
import com.RodriSolution.dslist.Services.GameService;
import com.RodriSolution.dslist.dto.GameListDTO;
import com.RodriSolution.dslist.dto.GameMinDTO;
import com.RodriSolution.dslist.dto.ReplacementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

        @Autowired
        private GameListService gameListService;

        @Autowired
        private GameService gameService;

        @GetMapping
        public List<GameListDTO> findAll() {
            List<GameListDTO> result = gameListService.findAll();
            return result;

        }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;

    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable long listId, @RequestBody ReplacementDTO body) {
            gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}

