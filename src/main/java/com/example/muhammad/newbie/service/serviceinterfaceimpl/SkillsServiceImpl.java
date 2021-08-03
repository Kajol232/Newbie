package com.example.muhammad.newbie.service.serviceinterfaceimpl;

import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.Skill;
import com.example.muhammad.newbie.model.User;
import com.example.muhammad.newbie.repository.SkillsRepository;
import com.example.muhammad.newbie.repository.UserRepository;
import com.example.muhammad.newbie.service.serviceinterface.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillsRepository skillsRepository;

    private Response response = new Response();
    @Override
    public Object addSkillset(String[] skills, long UserId) {
        User u = userRepository.findUsersById(UserId);
        List<Skill> skillList = u.getSkillSet();
        for (String s:skills) {
            Skill skill = new Skill(s);
            if(!skillsRepository.existsByName(s)){

                skillsRepository.save(skill);
            }
            skillList.addAll(Arrays.asList(skill));

        }
        u.setSkillSet(skillList);
        userRepository.save(u);
        response.setStatus("00");
        response.setMessage("Skill added successfully");
        return response;

    }

    @Override
    public Object updateSkills(int id, Skill skill) {
        Skill s = skillsRepository.findById(id).get();
        s.setName(skill.getName());
        skillsRepository.save(s);
        response.setStatus("00");
        response.setMessage("Skill updated successfully");
        return response;
    }


}
