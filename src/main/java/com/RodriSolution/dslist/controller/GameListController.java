package com.RodriSolution.dslist.controller;

import com.RodriSolution.dslist.Services.GameListService;
import com.RodriSolution.dslist.dto.GameListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

        @Autowired
        private GameListService gameListService;
        
        @GetMapping
        public List<GameListDTO> findAll() {
            List<GameListDTO> result = gameListService.findAll();
            return result;

        }

    }

