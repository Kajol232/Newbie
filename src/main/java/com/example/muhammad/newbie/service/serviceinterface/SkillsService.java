package com.example.muhammad.newbie.service.serviceinterface;

import com.example.muhammad.newbie.model.Skill;

public interface SkillsService {
    Object addSkillset(String[] skills, long UserId);
    Object updateSkills(int id, Skill skill);

}
