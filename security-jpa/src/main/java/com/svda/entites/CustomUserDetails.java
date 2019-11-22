package com.svda.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails  implements UserDetails{
	User user;
	private String email;
	private String password;


	public CustomUserDetails(Optional<User> optionalUsers) {
		// TODO Auto-generated constructor stub
		this.user = optionalUsers.get();
		this.email = optionalUsers.get().getEmail();
		this.password = optionalUsers.get().getPassword();				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		Set<Roles> roles = user.getRoles();
		roles.forEach(e-> {
			GrantedAuthority authority=	new SimpleGrantedAuthority(e.getRoleName());
			grantedAuthorities.add(authority);
		});

		return  grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
