package ru.itis.restbrieflib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.restbrieflib.models.Note;
import ru.itis.restbrieflib.models.User;

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
                .build();
    }
    public static List<NoteDto> from(List<Note> notes) {
        return notes.stream()
                .map(NoteDto::from)
                .collect(Collectors.toList());
    }
}
