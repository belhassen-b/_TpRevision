package com.example.infrastructurespringdata.repository;

import com.example.infrastructurespringdata.entity.UserAppEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppEntityRepository extends CrudRepository<UserAppEntity, Integer> {

    UserAppEntity findByUsernameAndPassword(String username, String password);
    UserAppEntity findByUsername(String username);
}
