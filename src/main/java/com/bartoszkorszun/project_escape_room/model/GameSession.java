package com.bartoszkorszun.project_escape_room.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;
    private boolean started;
    private boolean completed;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "gameSession", cascade = CascadeType.ALL)
    private List<Player> players;
}