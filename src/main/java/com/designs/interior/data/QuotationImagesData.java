package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.QuotationImage;
import com.designs.interior.remote.QuotationImagesRemote;
import com.designs.interior.repository.QuotationImagesRepository;

@Service
public class QuotationImagesData implements QuotationImagesRemote 
{
	@Autowired
	private QuotationImagesRepository quotationImagesRepository;

	@Override
	public String addNewImage(QuotationImage quotationImage) {
		String s = "";
		try
		{
			quotationImagesRepository.save(quotationImage);
			s = "Image saved successfully";
		}
		catch(Exception e)
		{
			s = "File size too big, try with size less than 1 MB";
		}
		return s;
	}

	@Override
	public List<QuotationImage> getAllQuotationImages() {
		List<QuotationImage> quotationImages = (List<QuotationImage>) quotationImagesRepository.findAll();
		return quotationImages;
	}

	@Override
	public QuotationImage getImageById(int id) {
		return quotationImagesRepository.findById(id).get();
	}

	@Override
	public String deleteImageById(int id) 
	{
		quotationImagesRepository.deleteById(id);
		return "Deleted Successfully";
	}
}
