package ru.itis.restbrieflib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotesSearchResult {
    private List<NoteDto> notes;
    private Integer count;
}
