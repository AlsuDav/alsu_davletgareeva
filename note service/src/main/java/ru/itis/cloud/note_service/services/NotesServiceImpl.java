package ru.itis.cloud.note_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.itis.cloud.note_service.models.Note;
import ru.itis.cloud.note_service.repositories.NotesRepository;

import java.util.List;
@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    public NotesRepository repository;
    @Override
    public List<Note> getAll() {
        return repository.findAll();
    }
}
