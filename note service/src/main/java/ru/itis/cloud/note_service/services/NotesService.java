package ru.itis.cloud.note_service.services;




import ru.itis.cloud.note_service.models.Note;

import java.util.List;

public interface NotesService {
    List<Note> getAll();
}
