package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.NoteDto;
import ru.itis.springbootdemo.dto.NotesSearchResult;
import ru.itis.springbootdemo.models.AccessType;
import ru.itis.springbootdemo.models.Note;
import ru.itis.springbootdemo.repositories.NotesRepository;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private NotesRepository repository;

    @Override
    public NotesSearchResult searchNotes(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Note> pageResult =  repository.search(query, pageRequest);
        List<NoteDto> notes = NoteDto.from(pageResult.getContent());
        return NotesSearchResult.builder()
                .notes(notes)
                .count(pageResult.getTotalPages())
                .build();
    }

}

