package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.Note;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.Optional;

public interface NotesRepository extends JpaRepository<Note, Long> {
        List<Note> findAll();
        @Query("from Note note where " +

                "upper(note.author) like concat('%', upper(:query), '%') or " +
                "upper(note.title) like concat('%', upper(:query), '%') or " +
                "upper(note.grade) like concat('%', upper(:query), '%')")
        Page<Note> search(@Param("query") String query, Pageable pageable);

        List<Note> findAllByUser(User user);

        Optional<Note> findNoteById(Long id);

}
