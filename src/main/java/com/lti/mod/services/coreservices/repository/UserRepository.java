package com.lti.mod.services.coreservices.repository;
import org.springframework.data.repository.CrudRepository;

import com.lti.mod.services.coreservices.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByEmail(String email);
}