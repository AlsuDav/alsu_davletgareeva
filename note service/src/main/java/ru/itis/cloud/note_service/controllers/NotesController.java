package ru.itis.cloud.note_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itis.cloud.note_service.models.Note;
import ru.itis.cloud.note_service.services.NotesService;

import java.util.List;

@RestController
public class NotesController {
    @Autowired
    private NotesService service;
    @GetMapping("/notes")
    public List<Note> getNotes(){
        return service.getAll();
    }

}
