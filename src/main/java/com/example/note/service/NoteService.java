package com.example.note.service;

import com.example.note.model.Note;
import com.example.note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> searchNotes(String query) {
        return noteRepository.findByNameContainingOrContentContaining(query, query);
    }

    public List<Note> getNotesBetweenDates(Date startDate, Date endDate) {
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        return noteRepository.findByCreatedAtBetween(startDate, endDate);
    }
}

