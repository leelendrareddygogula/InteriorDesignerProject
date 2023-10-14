package com.designs.interior.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.designs.interior.entity.Designer;
import com.designs.interior.remote.DesignerRemote;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private DesignerRemote designerRemote;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		Designer designer = designerRemote.getByUsername(username);
		
		if(designer == null)
		{
			throw new UsernameNotFoundException("User Doesn't Exist");
		}
		else
		{
			return new CustomerUser(designer);
		}
	}
	
}
