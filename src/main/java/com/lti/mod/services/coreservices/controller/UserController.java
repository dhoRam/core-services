package com.lti.mod.services.coreservices.controller;

import com.lti.mod.services.coreservices.model.UserDto;
import com.lti.mod.services.coreservices.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class UserController {
    @Autowired
    private UserRegistrationService userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        System.out.println("Saved ##########");
        return ResponseEntity.ok(userDetailsService.save(user));
    }
}
