package ru.itis.cloud.note_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.itis.cloud.note_service.models.Note;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Long> {

    List<Note> findAll();
}
