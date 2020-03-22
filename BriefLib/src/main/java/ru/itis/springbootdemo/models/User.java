package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor //constructor with all parameters
@NoArgsConstructor //constructor without parameters
@Builder //pattern
@Entity
@Table(name = "itis_user2")
//на основе класса создается таблица itis_user
// в postgres не должно быть таблицы с названием user, она уже зарезервирована
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String hashPassword;
    private LocalDateTime createdAt;

    @Enumerated(value = EnumType.STRING)
    //если String, то в базе сохранится строка, если Ordinal - то номера(1,2),
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String confirmCode;

}