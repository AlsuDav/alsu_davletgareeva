package ru.itis.restbrieflib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.restbrieflib.dto.NotesSearchResult;
import ru.itis.restbrieflib.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService service;

    // /search/notes?q=...&page=1&size=2
    @GetMapping("/notes")
    public NotesSearchResult searchNotes(@RequestParam("q") String query,
                                         @RequestParam("page") Integer page,
                                         @RequestParam("size") Integer size) {
        return service.searchNotes(query, page, size);
    }
}
