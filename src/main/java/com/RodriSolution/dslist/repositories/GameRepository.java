package com.RodriSolution.dslist.repositories;

import com.RodriSolution.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{

}
