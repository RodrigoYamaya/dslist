package com.RodriSolution.dslist.repositories;

import com.RodriSolution.dslist.dto.GameListDTO;
import com.RodriSolution.dslist.entities.Game;
import com.RodriSolution.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
