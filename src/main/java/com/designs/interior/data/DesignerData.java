package com.designs.interior.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Designer;
import com.designs.interior.remote.DesignerRemote;
import com.designs.interior.repository.DesignerRepository;

@Service
public class DesignerData implements DesignerRemote
{
	@Autowired
	private DesignerRepository designerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Designer getDesignerDetails(String uname, String pwd) 
	{
		Designer designer = designerRepository.checkDesignerDetails(uname, pwd);
		return designer;
	}

	@Override
	public Designer getByUsername(String uname) 
	{
		return designerRepository.findById(uname).get();
	}

	@Override
	public String addNewDesigner(Designer designer) 
	{
		String string = bCryptPasswordEncoder.encode(designer.getPassword());
		designer.setPassword(string);
		designer.setRole("ROLE_ADMIN");
		designerRepository.save(designer);
		return "Saved Successfully";
	}
	
}
