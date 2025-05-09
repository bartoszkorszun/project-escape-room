package com.bartoszkorszun.project_escape_room.controller;

import com.bartoszkorszun.project_escape_room.model.GameSession;
import com.bartoszkorszun.project_escape_room.model.Player;
import com.bartoszkorszun.project_escape_room.service.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class GameSessionController {
    private final GameSessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<GameSession> createSession(@RequestBody Map<String, Object> request) {
        String roomName = (String) request.get("roomName");
        String username = (String) request.get("username");
        Long roomId = Long.valueOf(request.get("roomId").toString());

        return ResponseEntity.ok(sessionService.createGameSession(roomName, username, roomId));
    }

    @PostMapping("/{sessionId}/join")
    public ResponseEntity<Player> joinSession(
        @PathVariable Long sessionId, 
        @RequestBody Map<String, String> request
    ) {
        String username = request.get("username");
        return ResponseEntity.ok(sessionService.joinSession(sessionId, username));
    }

    @GetMapping
    public ResponseEntity<List<GameSession>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSession> getSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getSessionById(id));
    }
}