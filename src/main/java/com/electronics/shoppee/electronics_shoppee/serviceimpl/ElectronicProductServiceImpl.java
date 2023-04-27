package com.electronics.shoppee.electronics_shoppee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IProductRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IProductTypeRepo;
import com.electronics.shoppee.electronics_shoppee.entity.ProductEntity;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.model.ProducDTO;
import com.electronics.shoppee.electronics_shoppee.service.IElectronicProductService;

@Service
public class ElectronicProductServiceImpl implements IElectronicProductService{


	@Autowired
	private IProductTypeRepo iProductTypeRepo;
	
	@Autowired
	private IProductRepo iProductRepo;
	
	@Override
	public ProductEntity addElectronicProduct(ProducDTO producDTO) {
	
			if(iProductTypeRepo.findById(producDTO.getProductTypeId()).isPresent()) {
				ProductEntity productEntity = new ProductEntity();
				
				productEntity.setCreateDate(producDTO.getCreateDate());
				productEntity.setImage(producDTO.getImage());
				productEntity.setProductName(producDTO.getProductName());
				productEntity.setProductPrice(producDTO.getProductPrice());
				
				productEntity.setProducttype(iProductTypeRepo.findById(producDTO.getProductTypeId()).get());
				productEntity = iProductRepo.save(productEntity);
				return productEntity;
			}
			else {
				throw new DoesnotExistsException("Product type doesnt exists with id: "+producDTO.getProductTypeId());
			}
	}

	@Override
	public ProductEntity updateElectronicProduct(int id, ProducDTO producDTO) {
		if(iProductRepo.findById(id).isPresent()) {
			if(iProductTypeRepo.findById(producDTO.getProductTypeId()).isPresent()) {
				ProductEntity productEntity = new ProductEntity();
				
				productEntity.setCreateDate(producDTO.getCreateDate());
				productEntity.setImage(producDTO.getImage());
				productEntity.setProductName(producDTO.getProductName());
				productEntity.setProductPrice(producDTO.getProductPrice());
				productEntity.setProductId(id);
				productEntity.setProducttype(iProductTypeRepo.findById(producDTO.getProductTypeId()).get());
				productEntity = iProductRepo.save(productEntity);
				return productEntity;
			}
			else {
				throw new DoesnotExistsException("Product type doesnt exists with id: "+producDTO.getProductTypeId());
			}
		}else {
			throw new DoesnotExistsException("Product doesnt exists with id: "+id);
		}
	}

	@Override
	public ProductEntity deleteElectronicProduct(int id) {
		if(iProductRepo.findById(id).isPresent()) {
			ProductEntity productEntity = iProductRepo.findById(id).get();
			iProductRepo.deleteById(id);
			return productEntity;

		}else {
			throw new DoesnotExistsException("Product doesnt exists with id: "+id);
		}
	}

	@Override
	public ProductEntity getElectronicProductById(int id) {
		if(iProductRepo.findById(id).isPresent()) {
			ProductEntity productEntity = iProductRepo.findById(id).get();
			return productEntity;

		}else {
			throw new DoesnotExistsException("Product doesnt exists with id: "+id);
		}
	}

	@Override
	public List<ProductEntity> getAllElectronicProduct() {

		List<ProductEntity> productEntityList = iProductRepo.findAll();
		return productEntityList;
	}

}
