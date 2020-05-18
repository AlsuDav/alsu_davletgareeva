package ru.itis.restbrieflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.restbrieflib.dto.NoteDto;
import ru.itis.restbrieflib.models.AccessType;
import ru.itis.restbrieflib.models.Note;
import ru.itis.restbrieflib.models.User;
import ru.itis.restbrieflib.repositories.NotesRepository;
import ru.itis.restbrieflib.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    NotesRepository notesRepository;

    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<Note> findForId(Long id) {
        return null;
    }

    @Override
    public List<Note> getNotes() {
        return (List<Note>) notesRepository.findAll();
    }

    @Override
    public void createNote(NoteDto form, User user) {

        Note note = Note.builder()
                .author(form.getAuthor())
                .title(form.getTitle())
                .grade(form.getGrade())
                .createdAt(LocalDateTime.now())
                .accessType(AccessType.PRIVATE)
                .content(form.getContent())
                .user(user)
                .build();
        notesRepository.save(note);
    }

    @Override
    public void editNote(NoteDto form,  Note existNote) {
        existNote.setTitle(form.getTitle());
        existNote.setAuthor(form.getAuthor());
        existNote.setContent(form.getContent());
        existNote.setGrade(form.getGrade());
        notesRepository.save(existNote);
    }

    @Override
    public List<Note> getUserNotes(User user) {
        return (List<Note>) notesRepository.findAllByUser(user);
    }

    @Override
    public Note getConcreteNote(Long noteId) {
        Note note = notesRepository.getOne(noteId);
        return note;
    }

    @Override
    public void delete(Note note) {
        notesRepository.delete(note);
    }

    @Transactional
    @Override
    public List<Note> findNotes(String access, User user) {

        if (access.equals("all")){
            return notesRepository.findAllByUser(user);
        }
        if (access.equals("public")){
            return user.getPublicNotes();
        } else{
            return user.getPrivateNotes();
        }

    }

    @Override
    public List<Note> findNotesByUserId(String access, Long user_id) {
        User user = usersRepository.findById(user_id).get();

        return notesRepository.findAllByUser(user);
    }


}
