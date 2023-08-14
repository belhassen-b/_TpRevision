package org.example.service;


import org.example.entity.UserApp;
import org.example.port.repository.UserRepository;
import org.example.port.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserApp createUser(String username, String password) {
        UserApp userApp = new UserApp(username, password);
        return userRepository.save(userApp);
    }

    @Override
    public UserApp getUserByUserNameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserApp getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
