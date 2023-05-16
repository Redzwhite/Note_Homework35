package com.example.note.repository;

import com.example.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByNameContainingOrContentContaining(String name, String content);
    List<Note> findByCreatedAtBetween(Date startDate, Date endDate);
}

