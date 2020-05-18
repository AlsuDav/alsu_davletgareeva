package ru.itis.restbrieflib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.restbrieflib.dto.NoteDto;
import ru.itis.restbrieflib.models.Note;
import ru.itis.restbrieflib.models.User;
import ru.itis.restbrieflib.repositories.NotesRepository;
import ru.itis.restbrieflib.security.jwt.details.UserDetailsImpl;
import ru.itis.restbrieflib.service.NoteService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    public NoteService noteService;

    @Autowired
    public NotesRepository notesRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getUsers() {
        return ResponseEntity.ok(noteService.getNotes());
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/note/{note-id}")
    public ResponseEntity<Note> getConcreteNote(@PathVariable("note-id") Long noteId) {
        Note note = noteService.getConcreteNote(noteId);
        return ResponseEntity.ok(note);
    }

}

