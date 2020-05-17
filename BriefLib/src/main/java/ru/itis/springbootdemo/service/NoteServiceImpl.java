package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springbootdemo.dto.NoteDto;
import ru.itis.springbootdemo.models.AccessType;
import ru.itis.springbootdemo.models.Note;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.NotesRepository;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static ru.itis.springbootdemo.dto.NoteDto.from;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    NotesRepository notesRepository;
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


}
