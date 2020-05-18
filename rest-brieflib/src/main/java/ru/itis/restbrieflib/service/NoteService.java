package ru.itis.restbrieflib.service;

import ru.itis.restbrieflib.dto.NoteDto;
import ru.itis.restbrieflib.models.Note;
import ru.itis.restbrieflib.models.User;

import java.util.List;

public interface NoteService {
    List<Note> findForId(Long id);
    List<Note> getNotes();

    void createNote(NoteDto form, User user);
    void editNote(NoteDto form, Note note);

    List<Note> getUserNotes(User user);

    Note getConcreteNote(Long noteId);
    void delete(Note note);

    List<Note> findNotes(String access, User user);

    List<Note> findNotesByUserId(String access, Long user_id);
}
