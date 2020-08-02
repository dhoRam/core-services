package com.lti.mod.services.coreservices.repository;

import com.lti.mod.services.coreservices.model.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByEmail(String email);
    boolean  existsByEmail(String email);
}

