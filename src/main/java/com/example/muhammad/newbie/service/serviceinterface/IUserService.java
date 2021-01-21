package com.example.muhammad.newbie.service.serviceinterface;

import com.example.muhammad.newbie.model.Users;
import com.example.muhammad.newbie.model.dao.RegisterUser;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public interface IUserService {
    Object addUser(RegisterUser user, String roleName, MultipartFile multipartFile) throws ParseException, IOException;
    Object updateUserDetails(Users user, long id);
    void setStudentDetails(RegisterUser registerUser, Users user);
    void setRecruiterDetails(RegisterUser registerUser, Users user);
    String getSignedUser(Authentication authentication);


}
