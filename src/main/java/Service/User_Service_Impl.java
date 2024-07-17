package Service;

import Entity.User;
import Repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
