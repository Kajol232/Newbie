package com.example.muhammad.newbie.repository;

import com.example.muhammad.newbie.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skill, Integer> {
    boolean existsByName(String Name);
}
