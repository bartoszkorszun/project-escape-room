package com.bartoszkorszun.project_escape_room.repository;

import com.bartoszkorszun.project_escape_room.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByUsername(String username);
}