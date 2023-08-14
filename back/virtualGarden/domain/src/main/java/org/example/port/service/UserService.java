package org.example.port.service;
import org.example.entity.UserApp;



public interface UserService {
    UserApp createUser(String username, String password);
    UserApp getUserByUserNameAndPassword(String username, String password);
    UserApp getUserByUserName(String username);
}
