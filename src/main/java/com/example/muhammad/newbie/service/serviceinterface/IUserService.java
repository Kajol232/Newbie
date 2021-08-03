package com.example.muhammad.newbie.service.serviceinterface;

import com.example.muhammad.newbie.model.User;
import com.example.muhammad.newbie.model.dao.RegisterUser;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public interface IUserService {
    Object addUser(RegisterUser user, String roleName, MultipartFile multipartFile) throws ParseException, IOException;
    Object updateUserDetails(User user, long id);
    void setStudentDetails(RegisterUser registerUser, User user);
    void setRecruiterDetails(RegisterUser registerUser, User user);
    String getSignedUser(Authentication authentication);


}
