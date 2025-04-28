package com.bartoszkorszun.project_escape_room.repository;

import com.bartoszkorszun.project_escape_room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // TODO
}