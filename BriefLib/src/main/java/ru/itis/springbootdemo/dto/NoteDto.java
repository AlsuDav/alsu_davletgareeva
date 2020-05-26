package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.itis.springbootdemo.models.Note;
import ru.itis.springbootdemo.models.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDto {
    private String author;
    private Long id;
    private String content;
    private String title;
    private User user ;
    private String grade;
    private String access_type;
    private LocalDateTime createdAt;
    private String common_title;
    private String description;
    private String createdAtString;

    public static NoteDto from(Note note) {
        return NoteDto.builder()
                .author(note.getAuthor())
                .content(note.getContent())
                .id(note.getId())
                .title(note.getTitle())
                .user(note.getUser())
                .createdAt(note.getCreatedAt())
                .grade(note.getGrade())
                .access_type(note.getAccessType().name())
                .common_title(note.getCommon_title())
                .description(note.getDescription())
                .createdAtString(note.getCreatedAtString())
                .build();
    }
    public static List<NoteDto> from(List<Note> notes) {
        return notes.stream()
                .map(NoteDto::from)
                .collect(Collectors.toList());
    }
}
