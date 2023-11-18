package com.example.placementmodule.controller;

import com.example.placementmodule.model.CalendarEvent;
import com.example.placementmodule.repository.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    @Autowired
    private CalendarEventRepository eventRepository;

    @GetMapping("/events")
    public ResponseEntity<List<CalendarEvent>> getAllEvents() {
        List<CalendarEvent> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/upcoming")
    public ResponseEntity<List<CalendarEvent>> getUpcomingEvents() {
        List<CalendarEvent> upcomingEvents = eventRepository.findByEventDateTimeAfter(LocalDateTime.now());
        return ResponseEntity.ok(upcomingEvents);
    }

    @PostMapping("/events")
    public ResponseEntity<String> addEvent(@RequestBody CalendarEvent event) {
        eventRepository.save(event);
        return ResponseEntity.ok("Event added successfully");
    }

}
