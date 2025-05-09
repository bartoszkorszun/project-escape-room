package com.bartoszkorszun.project_escape_room.controller;

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

        return ResponseEntity.ok(sessionService.createSession(roomName, username, roomId));
    }

    @PostMapping("/{sessionId}/join")
    public ResponseEntity<Player> joinSession(
        @PathVariable Long sessionId, 
        @RequestBody Map<String, Object> request
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