package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.NoteDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.Note;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.NotesRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.NoteService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    public NoteService noteService;

    @Autowired
    public NotesRepository notesRepository;

    @GetMapping("/notes")
    public String getNotes(Model model){
        List<Note> notes = noteService.getNotes();
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/newNote")
    public String newNote(Authentication authentication, Model model){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        model.addAttribute("user", userDetails.getUser());
        return "noteForm";
    }

    @PostMapping("/newNote")
    public String createNote(Authentication authentication, NoteDto form){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user =  userDetails.getUser();
        noteService.createNote(form, user);
        return "redirect:/notes";
    }
    @GetMapping("/myNotes")
    public String getUserNotes(@RequestParam("access") String access, Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user =  userDetails.getUser();
        List<Note> notes = noteService.findNotes(access,user);
//        if(access.equals("all")){
//            notes = noteService.getUserNotes(user);
//        }
//        if(access.equals("public")){
//            notes = user.getPublicNotes();
//        } else {
//            notes = user.getPrivateNotes();
//        }
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        return "my_notes";
    }
//    @GetMapping("/myNotes/public")
//    public String getUserPublicNotes(Authentication authentication, Model model){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        User user =  userDetails.getUser();
//        List<Note> notes = user.getPublicNotes();
//        model.addAttribute("notes", notes);
//        model.addAttribute("user", user);
//        return "my_notes";
//    }
//    @GetMapping("/myNotes/private")
//    public String getUserPrivateNotes(Authentication authentication, Model model){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        User user =  userDetails.getUser();
//        List<Note> notes = user.getPrivateNotes();
//        model.addAttribute("notes", notes);
//        model.addAttribute("user", user);
//        return "my_notes";
//    }

    @GetMapping("note/{note-id}")
    public String getConcreteNote(Authentication authentication, @PathVariable("note-id") Long noteId, Model model) {
        Note note = noteService.getConcreteNote(noteId);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user =  userDetails.getUser();
        boolean isOwner = false;
        if (user.getId().equals(note.getUser().getId())){
            isOwner = true;
        }
        model.addAttribute("note", note);
        model.addAttribute("isOwner", isOwner);
        return "note_page";
    }

    @GetMapping("editNote/{note-id}")
    public String getEditNotePage(Authentication authentication, @PathVariable("note-id") Long noteId, Model model){
        Note note = noteService.getConcreteNote(noteId);
        model.addAttribute("note", note);
        return "noteEditForm";
    }
    @PostMapping("/editNote/{note-id}")
    public String editNote(Authentication authentication, @PathVariable("note-id") Long noteId, Model model,NoteDto form){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user =  userDetails.getUser();
        Note note = noteService.getConcreteNote(noteId);
        noteService.editNote(form, note);
        return "redirect:/myNotes";
    }
    @PostMapping("/deleteNote/{note-id}")
    public String deleteNote(Authentication authentication, @PathVariable("note-id") Long noteId, Model model, NoteDto form, Principal principal){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user =  userDetails.getUser();
        Optional<Note> optionalNote = notesRepository.findNoteById(noteId);
        System.out.println("this id user:" + user);
        System.out.println("this id note:" + optionalNote.get().getTitle());

        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();

            if (note.getUser().getId().equals(user.getId())) {
                noteService.delete(note);
                return "redirect:/myNotes";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

//    private boolean isPrincipalOwnerOfNote(Principal principal, Note note) {
//        return principal != null && principal.getName().equals(note.getUser().getName());
//    }
}
