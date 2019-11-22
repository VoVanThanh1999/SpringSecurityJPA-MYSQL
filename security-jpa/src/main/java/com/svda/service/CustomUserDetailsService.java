package com.svda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.svda.entites.CustomUserDetails;
import com.svda.entites.User;
import com.svda.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	   @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> optionalUsers = userRepository.findByEmail(username);
	        optionalUsers
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	        CustomUserDetails customUserDetails = new CustomUserDetails(optionalUsers);
	        return customUserDetails;
	    }




	


}
  