package com.electronics.shoppee.electronics_shoppee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IProductTypeRepo;
import com.electronics.shoppee.electronics_shoppee.entity.ProductTypeEntity;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.exception.UnhandledException;
import com.electronics.shoppee.electronics_shoppee.model.ProductTypeDTO;
import com.electronics.shoppee.electronics_shoppee.service.IElectronicProductTypeService;

@Service
public class ElectronicProductTypeServiceImpl implements IElectronicProductTypeService {

	@Autowired
	private IProductTypeRepo iProductTypeRepo;
	
	@Override
	public ProductTypeEntity addElectronicProductType(ProductTypeDTO productTypeDTO) {
		try {
			ProductTypeEntity productTypeEntity = new ProductTypeEntity();
			productTypeEntity.setProductTypeName(productTypeDTO.getProductTypeName());
			productTypeEntity = iProductTypeRepo.save(productTypeEntity);
			return productTypeEntity;
		}
		catch(Exception e) {
			throw new UnhandledException("something went wrong");
		}
	}

	@Override
	public ProductTypeEntity updateElectronicProductType(int id, ProductTypeDTO productTypeDTO) {
		if(iProductTypeRepo.findById(id).isPresent()) {
			ProductTypeEntity productTypeEntity = new ProductTypeEntity();
			productTypeEntity.setProductTypeName(productTypeDTO.getProductTypeName());
			productTypeEntity.setProductTypeId(id);
			productTypeEntity = iProductTypeRepo.save(productTypeEntity);
			return productTypeEntity;
		}
		else {
			throw new DoesnotExistsException("Product type doesnt exists with id: "+id);
		}
	}

	@Override
	public ProductTypeEntity deleteElectronicProductType(int id) {
		if(iProductTypeRepo.findById(id).isPresent()) {
			ProductTypeEntity productTypeEntity = iProductTypeRepo.findById(id).get();
			iProductTypeRepo.deleteById(id);
			return productTypeEntity;
		}
		else {
			throw new DoesnotExistsException("Product type doesnt exists with id: "+id);
		}
	}

	@Override
	public ProductTypeEntity getElectronicProductTypeById(int id) {
		if(iProductTypeRepo.findById(id).isPresent()) {
			ProductTypeEntity productTypeEntity = iProductTypeRepo.findById(id).get();
			return productTypeEntity;
		}
		else {
			throw new DoesnotExistsException("Product type doesnt exists with id: "+id);
		}
	}

	@Override
	public List<ProductTypeEntity> getElectronicProductTypeById() {
		List<ProductTypeEntity> productTypeEntityList = iProductTypeRepo.findAll();
		return productTypeEntityList;
		
	}

}
