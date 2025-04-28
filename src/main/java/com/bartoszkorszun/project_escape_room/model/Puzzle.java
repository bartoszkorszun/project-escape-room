package com.bartoszkorszun.project_escape_room.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;
    private boolean solved;

    private int orderInRoom;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}