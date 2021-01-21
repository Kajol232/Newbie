package com.example.muhammad.newbie.repository;

import com.example.muhammad.newbie.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
    Users findUserByEmail(String email);
    Users findUsersById(long id);
}
