package com.example.muhammad.newbie.service.serviceinterfaceimpl;

import com.example.muhammad.newbie.model.*;
import com.example.muhammad.newbie.model.dao.RegisterUser;
import com.example.muhammad.newbie.repository.RequestRepository;
import com.example.muhammad.newbie.repository.UserRepository;
import com.example.muhammad.newbie.repository.UserRoleRepository;
import com.example.muhammad.newbie.service.serviceinterface.IUserService;
import com.example.muhammad.newbie.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository roleRepository;
    @Autowired
    private RequestRepository requestRepository;
    private Response response = new Response();

    private String uploadDir = "C:\\Users\\user\\Documents\\newbie\\src\\main\\resources\\static\\userImages\\";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            Users users = optionalUser.get();
            List<String> roleList = new ArrayList<String>();
            for(UserRole role: users.getRoles()){
                roleList.add(role.getName());
            }

            return User.builder()
                    .password(users.getPassword())
                    .disabled(users.isActive())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        }else {
            throw new UsernameNotFoundException("Email address is not found");
        }
    }

    public int dobConversion(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, d);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);

        return diff1.getYears();
    }


    @Override
    public Object addUser(RegisterUser registerUser, String roleName, MultipartFile multipartFile) throws ParseException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = sdf.parse(registerUser.getDob().toString());

        if (!registerUser.getPassword().equals(registerUser.getConfirmPassword())){
            response.setStatus("401");
            response.setMessage("Password does not match");
        }else if (userRepository.existsByEmail(registerUser.getEmail())){
            response.setStatus("401");
            response.setMessage("User exist");
        }else if(!registerUser.getEmail().contains("@") || !registerUser.getEmail().contains(".")){
            response.setStatus("401");
            response.setMessage("Invalid email");
        }else if(registerUser.getPassword().isBlank() || registerUser.getPassword().isEmpty()) {
            response.setStatus("401");
            response.setMessage("Password cannot be blank");
        }else if (dobConversion(dob) < 18 ){
            response.setStatus("401");
            response.setMessage("You must be 18+ to register");

        }else {

            String fileName = UUID.randomUUID().toString();

            Users user = new Users();
            user.setName(registerUser.getName());
            user.setEmail(registerUser.getEmail());
            user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
            user.setDob(registerUser.getDob());
            user.setGender(registerUser.getGender());
            user.setMobile(registerUser.getMobile());
            user.setImageUrl(fileName);
            user.setEmailNotification(registerUser.isEmailNotification());
            if (roleName == "STUDENT") {
                setStudentDetails(registerUser, user);
                userRepository.save(user);
                uploadDir += user.getId();
                FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);
                Request request = new Request("StudentRequest", user);
                requestRepository.save(request);
                response.setStatus("00");
                response.setMessage("Created Successfully,Pending approval");
                return response;
            } else if (roleName == "RECRUITERS" || roleName =="COMPANY-ADMIN"){
                setRecruiterDetails(registerUser, user);
            }
            Optional<UserRole> optionalUserRole = roleRepository.findUserRoleByName(roleName);
            if (optionalUserRole.isPresent()) {
                UserRole userRole = optionalUserRole.get();
                List<UserRole> roleList = new ArrayList<>();
                roleList.add(userRole);
                user.setRoles(roleList);
            }
            userRepository.save(user);
            uploadDir += user.getId();
            FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);

            response.setStatus("00");
            response.setMessage("User created successfully");

        }
        return response;
    }

    @Override
    public Object updateUserDetails(Users user, long id) {
        Users u = userRepository.findUsersById(id);
        u.setDob(user.getDob());
        u.setGender(user.getGender());
        u.setMobile(user.getMobile());
        u.setEmailNotification(user.isEmailNotification());

        userRepository.save(u);
        response.setStatus("00");
        response.setMessage("Details Updated Successfully");

        return response;
    }

    @Override
    public void setStudentDetails(RegisterUser registerUser, Users user) {
        user.setSkillSet(registerUser.getSkillsetList());
        user.setInstitution(registerUser.getInstitution());
        user.setApproved(false);

    }

    @Override
    public void setRecruiterDetails(RegisterUser registerUser, Users user) {
        user.setCompany(registerUser.getCompany());
        user.setApproved(true);

    }


    @Override
    public String getSignedUser(Authentication authentication) {
        return null;
    }



}
