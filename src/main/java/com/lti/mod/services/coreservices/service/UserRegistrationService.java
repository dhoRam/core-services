package com.lti.mod.services.coreservices.service;

import com.lti.mod.services.coreservices.model.UserDao;
import com.lti.mod.services.coreservices.model.UserDto;
import com.lti.mod.services.coreservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDao save(UserDto user) {
		System.out.println(user.getRole());
		UserDao newUser = new UserDao();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setName(user.getName());
		newUser.setRole(user.getRole());
		newUser.setTechnology(user.getTechnology());
		return userDao.save(newUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}