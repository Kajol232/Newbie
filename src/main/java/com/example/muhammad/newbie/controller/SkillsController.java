package com.example.muhammad.newbie.controller;

import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.Skill;
import com.example.muhammad.newbie.repository.SkillsRepository;
import com.example.muhammad.newbie.service.serviceinterfaceimpl.SkillsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
@RequestMapping(value = "/skillsets")
public class SkillsController {
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private SkillsServiceImpl skillsetService;

    private Response response = new Response();

    @GetMapping(path = "/list")
    public List<Skill> getSkillsetLists(){
        return (List<Skill>) skillsRepository.findAll();
    }
    @GetMapping(path = "/getSkillById/{id}")
    public Skill getSkillById(@PathVariable("id") int id){
        return skillsRepository.findById(id).get();
    }

    @PostMapping(path = "/addSkillsets/{id}", consumes = "application/json", produces = "application/json")
    public Object addSkillSet(@PathVariable("id") long userId, String[] skills){
        return skillsetService.addSkillset(skills, userId);
    }
    @PostMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
    public Object updateSkillset(@PathVariable("id") int id, @RequestBody Skill skill){
        return skillsetService.updateSkills(id,skill);
    }
    @DeleteMapping(path = "/delete/{id}")
    public Object deleteSkill(@PathVariable("id") int id){
        Skill s = skillsRepository.findById(id).get();
        skillsRepository.delete(s);
        response.setStatus("00");
        response.setMessage("Skill deleted successfully");
        return response;
    }
}
