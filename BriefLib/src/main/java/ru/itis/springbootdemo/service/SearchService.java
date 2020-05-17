package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.NotesSearchResult;

public interface SearchService {
    NotesSearchResult searchNotes(String query, Integer page, Integer size);
}
