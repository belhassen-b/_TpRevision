package com.example.infrastructurespringdata.repository.impl;

import com.example.infrastructurespringdata.entity.UserAppEntity;
import com.example.infrastructurespringdata.repository.UserAppEntityRepository;
import org.example.entity.UserApp;

import org.example.port.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserAppEntityRepository userAppEntityRepository;
    private final ModelMapper modelMapper;
    public UserRepositoryImpl(UserAppEntityRepository userAppEntityRepository, ModelMapper modelMapper) {
        this.userAppEntityRepository = userAppEntityRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserApp save(UserApp userApp) {
        return modelMapper.map(
                userAppEntityRepository.save(
                        modelMapper.map(userApp, UserAppEntity.class)
                ),UserApp.class
        );
    }

    @Override
    public UserApp findByUsernameAndPassword(String username, String password) {
        return modelMapper.map(
                userAppEntityRepository.findByUsernameAndPassword(username, password), UserApp.class
        );
    }

    @Override
    public UserApp findByUsername(String username) {
        return modelMapper.map(
                userAppEntityRepository.findByUsername(username), UserApp.class
        );
    }
}
