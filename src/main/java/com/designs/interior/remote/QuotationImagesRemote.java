package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.QuotationImage;

public interface QuotationImagesRemote 
{
	public String addNewImage(QuotationImage quotationImage);
	public List<QuotationImage> getAllQuotationImages();
	public QuotationImage getImageById(int id);
	public String deleteImageById(int id);
}
