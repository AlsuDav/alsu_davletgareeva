package ru.itis.cloud.note_service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Note")
public class Note {
    @Id
    private Long id;

    private String note_name;
    private String author;
    private String title;
    private int grade;

}
