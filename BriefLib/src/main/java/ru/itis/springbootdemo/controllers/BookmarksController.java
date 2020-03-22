package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookmarksController {
    @GetMapping("/bookmarks")
    public String getBookmarks(){
        return "bookmarks";
    }
}
