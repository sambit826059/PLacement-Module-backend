// CalendarEventServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.CalendarEvent;
import com.example.placementmodule.repository.CalendarEventRepository;
import com.example.placementmodule.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {

    private final CalendarEventRepository calendarEventRepository;

    @Autowired
    public CalendarEventServiceImpl(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @Override
    public List<CalendarEvent> getAllCalendarEvents() {
        return calendarEventRepository.findAll();
    }

    @Override
    public Optional<CalendarEvent> getCalendarEventById(Long id) {
        return calendarEventRepository.findById(id);
    }

    @Override
    public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent) {
        return calendarEventRepository.save(calendarEvent);
    }

    @Override
    public CalendarEvent updateCalendarEvent(Long id, CalendarEvent updatedCalendarEvent) {
        Optional<CalendarEvent> existingCalendarEvent = calendarEventRepository.findById(id);

        if (existingCalendarEvent.isPresent()) {
            CalendarEvent calendarEvent = existingCalendarEvent.get();
            // Update the fields you want to update
            if (updatedCalendarEvent.getEventName() != null) {
                calendarEvent.setEventName(updatedCalendarEvent.getEventName());
            }

            if (updatedCalendarEvent.getEventDateTime() != null) {
                calendarEvent.setEventDateTime(updatedCalendarEvent.getEventDateTime());
            }

            if (updatedCalendarEvent.getLocation() != null) {
                calendarEvent.setLocation(updatedCalendarEvent.getLocation());
            }

            // ... update other fields as needed

            return calendarEventRepository.save(calendarEvent);
        } else {
            // Handle the case where the calendar event with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteCalendarEvent(Long id) {
        calendarEventRepository.deleteById(id);
    }
}
