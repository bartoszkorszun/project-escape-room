package com.bartoszkorszun.project_escape_room.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private boolean isHost;

    @ManyToOne
    @JoinColumn(name = "game_session_id")
    private GameSession gameSession;

    private boolean connected;
}