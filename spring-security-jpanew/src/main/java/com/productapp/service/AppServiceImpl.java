package com.productapp.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productapp.model.AppUser;
import com.productapp.repository.IAppUserRepository;

@Service
public class AppServiceImpl implements UserDetailsService {

	@Autowired
	IAppUserRepository appUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username   " +username);
		AppUser appUser=appUserRepository.findByUsername(username);
		GrantedAuthority aauthority= new SimpleGrantedAuthority("ADMIN");
		GrantedAuthority uauthority= new SimpleGrantedAuthority("USER");
		Set<GrantedAuthority> authorities =new HashSet<>(Arrays.asList(aauthority,uauthority));
		
		UserDetails userDetails=new User(username,appUser.getPassword(),authorities);
		System.out.println(userDetails);
		return userDetails;
	}
	
	public void addUser(AppUser user)
	{
	       appUserRepository.save(user);
	}

}
