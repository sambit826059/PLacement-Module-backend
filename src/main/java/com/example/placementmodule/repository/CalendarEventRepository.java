package com.example.placementmodule.repository;

import com.example.placementmodule.model.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
    List<CalendarEvent> findByEventDateTimeAfter(LocalDateTime dateTime);

}
