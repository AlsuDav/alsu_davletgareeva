package ru.itis.restbrieflib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAllByNameContainsIgnoreCase(String name);
    Optional<User> findByConfirmCode(String ConfirmCode);
}
