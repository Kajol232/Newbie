package com.example.muhammad.newbie.repository;

import com.example.muhammad.newbie.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    User findUserByEmail(String email);
    User findUsersById(long id);
}
