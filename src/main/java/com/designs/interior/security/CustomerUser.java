package com.designs.interior.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.designs.interior.entity.Designer;

public class CustomerUser implements UserDetails
{
	
	private Designer designer;
	

	public CustomerUser(Designer designer) {
		super();
		this.designer = designer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(designer.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return designer.getPassword();
	}

	@Override
	public String getUsername() {
		return designer.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
