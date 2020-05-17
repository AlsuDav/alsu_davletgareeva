package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.NoteDto;
import ru.itis.springbootdemo.models.Note;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> findForId(Long id);
    List<Note> getNotes();

    void createNote(NoteDto form, User user);
    void editNote(NoteDto form, Note note);

    List<Note> getUserNotes(User user);

    Note getConcreteNote(Long noteId);
    void delete(Note note);

}
