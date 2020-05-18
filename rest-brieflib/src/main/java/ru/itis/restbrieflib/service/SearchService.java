package ru.itis.restbrieflib.service;

import ru.itis.restbrieflib.dto.NotesSearchResult;

public interface SearchService {
    NotesSearchResult searchNotes(String query, Integer page, Integer size);
}
