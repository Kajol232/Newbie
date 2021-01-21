package com.example.muhammad.newbie.repository;

import com.example.muhammad.newbie.model.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    Optional<UserRole> findUserRoleByName(String roleName);
}
