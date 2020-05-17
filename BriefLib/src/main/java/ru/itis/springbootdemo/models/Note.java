package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor //constructor with all parameters
@NoArgsConstructor //constructor without parameters
@Builder //pattern
@Entity
@Table(name = "notes")
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String grade;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @Transient
    private String common_title;

    @Transient
    private String description;

    @Transient
    private String createdAtString;

    @Enumerated(value = EnumType.STRING)
    private AccessType accessType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PostLoad
    public void setCommonTitle() {
        common_title = author + "  \" " + title + " \" ";
        description = content.substring(0,100) + "...";
        createdAtString = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


//    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
//    private Collection<Comment> comments;
}