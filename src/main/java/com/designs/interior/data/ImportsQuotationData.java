package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.ImportsQuotation;
import com.designs.interior.remote.ImportsQuotationRemote;
import com.designs.interior.repository.ImportsQuotationRepository;

@Service
public class ImportsQuotationData implements ImportsQuotationRemote
{
	
	@Autowired
	private ImportsQuotationRepository importsQuotationRepository;
	
	@Override
	public void addImportsQuotation(ImportsQuotation importsQuotation) {
		importsQuotationRepository.save(importsQuotation);
	}

	@Override
	public void deleteImportsQuotationById(int cid) {
		importsQuotationRepository.deleteById(cid);
	}

	@Override
	public List<ImportsQuotation> getListbyId(int id) {
		List<ImportsQuotation> importsQuotations = importsQuotationRepository.getTuplesByQuotId(id);
		return importsQuotations;
	}

	@Override
	public ImportsQuotation getDetailsById(int id) 
	{
		return importsQuotationRepository.findById(id).get();
	}
	
}
