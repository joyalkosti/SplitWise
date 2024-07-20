package Service;

import Entity.User;
import Repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import Exception.*;

@Service
public class User_Service_Impl implements User_Service {

    @Autowired
    private User_Repository user_repository;

    @Override
    public User signUp(String name, String email, String password) {
        BCryptPasswordEncoder Encoder=new BCryptPasswordEncoder();


        User user=new User();
        user.setName(name);
        user.setEmail(email);
         user.setPassword(Encoder.encode(password));

        return user_repository.save(user);
    }

    @Override
    public User login(String email, String password) {
        BCryptPasswordEncoder Encoder =new BCryptPasswordEncoder();
        User savedUser=user_repository.findUserByEmail(email);
        if(savedUser==null){
            throw new User_DoesNotExist_Exception("User not found");

        }
        if(Encoder.matches(password,savedUser.getPassword()))
            return savedUser;
        else {
            throw new Invalid_Credentials_Exception("Invalid ");
        }
    }
}
