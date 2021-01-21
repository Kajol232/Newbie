package com.example.muhammad.newbie.controller;

import com.example.muhammad.newbie.model.Response;
import com.example.muhammad.newbie.model.Users;
import com.example.muhammad.newbie.model.dao.RegisterUser;
import com.example.muhammad.newbie.repository.UserRepository;
import com.example.muhammad.newbie.repository.UserRoleRepository;
import com.example.muhammad.newbie.service.serviceinterfaceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRoleRepository roleRepository;

    private Response response = new Response();


    @GetMapping(path = "/lists", produces = "application/json")
    public List<Users> getAllUsers(){
        return (List<Users>) userRepository.findAll();
    }

    @GetMapping(path = "/getUserById/{id}")
    public Users getUserById(@PathVariable("id") long id){
        return userRepository.findUsersById(id);
    }

    @PostMapping(path = "/addAdmins", consumes = "application/json",produces = "application/json")
    public Object addAdmins(@RequestBody RegisterUser registerUser, @RequestParam ("image") MultipartFile multipartFile) throws IOException, ParseException {
        String roleName = "ADMIN";
        return userDetailsService.addUser(registerUser, roleName, multipartFile);
    }

    @PostMapping(path = "/addStudents", consumes = "application/json",produces = "application/json")
    public Object addStudents(@RequestBody RegisterUser registerUser, @RequestParam ("image") MultipartFile multipartFile) throws IOException, ParseException {
        String roleName = "STUDENT";
        return userDetailsService.addUser(registerUser, roleName, multipartFile);
    }

    @PostMapping(path="/update/{id}", consumes ="application/json", produces ="application/json" )
    public Object updateUserDetails(@RequestBody Users user, @PathVariable("id") long id){
        return userDetailsService.updateUserDetails(user, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Object deleteUser(@PathVariable("id") long id){
        Users u = userRepository.findUsersById(id);
        userRepository.delete(u);
        response.setStatus("00");
        response.setMessage("Role deleted successfully");
        return response;

    }

}
