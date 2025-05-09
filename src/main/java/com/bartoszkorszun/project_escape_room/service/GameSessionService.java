package com.bartoszkorszun.project_escape_room.service;

import java.time.LocalDateTime;

import com.bartoszkorszun.project_escape_room.model.GameSession;
import com.bartoszkorszun.project_escape_room.model.Player;
import com.bartoszkorszun.project_escape_room.repository.PlayerRepository;
import com.bartoszkorszun.project_escape_room.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class GameSessionService {
    private final GameSessionRepository gameSessionRepository;
    private final PlayerRepository playerRepository;
    private final RoomRepository roomRepository;

    public GameSession createGameSession(
        String roomName,
        String hostUsername,
        Long roomId
    ) {
        Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new RuntimeException("Room not found"));
        
        GameSession session = GameSession.builder()
            .roomName(roomName)
            .createdAt(LocalDateTime.now())
            .started(false)
            .completed(false)
            .build();
        
        GameSession savedSession = gameSessionRepository.save(session);

        Player host = Player.builder()
            .userName(hostUsername)
            .isHost(true)
            .connected(true)
            .gameSession(savedSession)
            .build();

        playerRepository.save(host);

        return savedSession;
    }

    public List<GameSession> getAllSessions() {
        return gameSessionRepository.findAll();
    }

    public GameSession getSessionById(Long id) {
        return gameSessionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public Player joinSession(Long sessionId, String username) {
        GameSession session = getSessionById(sessionId);

        Player player = Player.builder()
            .userName(username)
            .isHost(false)
            .connected(true)
            .gameSession(session)
            .build();
            
        return playerRepository.save(player);
    }
}