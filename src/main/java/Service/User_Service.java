package Service;

import Entity.User;

public interface User_Service {

    User signUp(String name, String email, String password);
}
