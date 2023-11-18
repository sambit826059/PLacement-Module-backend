// CalendarEventService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.CalendarEvent;

import java.util.List;
import java.util.Optional;

public interface CalendarEventService {
    List<CalendarEvent> getAllCalendarEvents();

    Optional<CalendarEvent> getCalendarEventById(Long id);

    CalendarEvent createCalendarEvent(CalendarEvent calendarEvent);

    CalendarEvent updateCalendarEvent(Long id, CalendarEvent updatedCalendarEvent);

    void deleteCalendarEvent(Long id);
}
