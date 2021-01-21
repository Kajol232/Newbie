package com.example.muhammad.newbie.controller;

import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.UserRole;
import com.example.muhammad.newbie.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "http://localhost:8181")
@RequestMapping(value = "/roles")
public class UserRoleController {
    @Autowired
    UserRoleRepository roleRepository;

    private Response response = new Response();

    @GetMapping(path = "/lists",produces = "application/json")
    public List<UserRole> roles(){
        return (List) roleRepository.findAll();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Object createRole(@RequestParam("name") String name){
        UserRole role = new UserRole(name);
        roleRepository.save(role);
        response.setStatus("00");
        response.setMessage("Role created successfully");

        return response;
    }

    @PostMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
    public Object updateRole(@RequestParam("name") String name, @PathVariable("id") int id){
        UserRole role = roleRepository.findById(id).get();
        role.setName(name);
        response.setStatus("00");
        response.setMessage("Role updated successfully");

        return response;
    }

    @DeleteMapping(path = "/delete/{id}")
    public Object deleteRole(@PathVariable("id") int id){
        UserRole role = roleRepository.findById(id).get();
        roleRepository.delete(role);
        response.setStatus("00");
        response.setMessage("Role deleted successfully");
        return response;
    }
    @GetMapping(path = "/getRoleById/{id}")
    public UserRole getRoleById(@PathVariable("id") int id){
        return roleRepository.findById(id).get();
    }



}
