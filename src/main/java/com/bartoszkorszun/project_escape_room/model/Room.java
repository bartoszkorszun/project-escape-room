package com.bartoszkorszun.project_escape_room.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;
    private int difficulty;
    private int maxPlayers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Puzzle> puzzles;
}