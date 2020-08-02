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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDao user = userDao.findByEmail(email);
		System.out.println(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
		return (UserDetails) user;
	}

	public UserDao save(UserDto user) {
		boolean userExists = userDao.existsByEmail(user.getEmail());
		if (!userExists && user.getEmail() != null && user.getName() !=null && user.getPassword() !=null ) {
			UserDao newUser = new UserDao();
			newUser.setEmail(user.getEmail());
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			newUser.setName(user.getName());
			newUser.setRole(user.getRole());
			newUser.setTechnology(user.getTechnology());
			return userDao.save(newUser);
		}else {
			throw new UsernameNotFoundException("Email already exists : " + user.getEmail());
		}
	}
}