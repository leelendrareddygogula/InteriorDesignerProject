package com.designs.interior.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.QuotationImage;

@Repository
public interface QuotationImagesRepository extends CrudRepository<QuotationImage, Integer>
{
	
}
