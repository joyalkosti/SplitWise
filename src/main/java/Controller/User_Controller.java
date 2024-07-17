package Controller;

import DTOs.User_DTOs;
import Entity.User;
import Mapper.EntityDTO_Mapper;
import Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Exception.*;

@RestController
public class User_Controller {

    @Autowired
    private User_Service user_service;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody User_DTOs user_dtOs){
        validateUserDto(user_dtOs);

        User savedUser=user_service.signUp(user_dtOs.getName(), user_dtOs.getEmail(), user_dtOs.getPassword());

        return ResponseEntity.ok(EntityDTO_Mapper.toDto(savedUser));
    }
    private void validateUserDto(User_DTOs validate_Dto){
        if(validate_Dto.getEmail()==null || validate_Dto.getName()==null || validate_Dto.getPassword()==null){
            throw new User_Invalid_Data_Exception("Invalid signup ");
        }

    }
}
