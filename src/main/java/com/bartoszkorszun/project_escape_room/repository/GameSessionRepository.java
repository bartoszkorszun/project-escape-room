package com.bartoszkorszun.project_escape_room.repository;

import com.bartoszkorszun.project_escape_room.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    GameSession findByGameSessionId(Long gameSessionId);
}