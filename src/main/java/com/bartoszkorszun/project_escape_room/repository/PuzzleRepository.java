package com.bartoszkorszun.project_escape_room.repository;

import com.bartoszkorszun.project_escape_room.model.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
    //TODO
}