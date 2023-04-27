package com.electronics.shoppee.electronics_shoppee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IProductOrderRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IProductRepo;
import com.electronics.shoppee.electronics_shoppee.entity.ProductEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductOrderEntity;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.exception.UnhandledException;
import com.electronics.shoppee.electronics_shoppee.model.ProductOrderDTO;
import com.electronics.shoppee.electronics_shoppee.service.IElectronicProdctOrderService;

@Service
public class ElectronicProdctOrderServiceImpl implements IElectronicProdctOrderService {

	@Autowired
	private IProductRepo iProductRepo;
	
	@Autowired
	private IProductOrderRepo iProductOrderRepo;
	
	@Override
	public ProductOrderEntity addProductOrder(ProductOrderDTO productOrderDTO) {
		List<ProductEntity> productEntityList = new ArrayList<>();	
		for(int productId: productOrderDTO.getProducts()) {
			if(iProductRepo.findById(productId).isPresent()) {
				productEntityList.add(iProductRepo.findById(productId).get());
			}
			else {
				throw new DoesnotExistsException("Product doesnt exists with id: "+productId);
			}
		}
		try {
			ProductOrderEntity productOrderEntity = new ProductOrderEntity();
			
			productOrderEntity.setOrderDate(productOrderDTO.getOrderDate());
			
			productOrderEntity.setProducts(productEntityList);
			productOrderEntity.setOrderStatus(productOrderDTO.getOrderStatus());
			productOrderEntity.setTotalAmount(productOrderDTO.getTotalAmount());

			productOrderEntity = iProductOrderRepo.save(productOrderEntity);
			return productOrderEntity;
		}
		catch(Exception e) {
			throw new UnhandledException("something went wrong");
		}
		
//		ProductOrderEntity productOrderEntity = new ProductOrderEntity();
//		BeanUtils.copyProperties(productOrderDTO, productOrderEntity);
//
//		ProductOrderEntity newProductOrderEntity = iProductOrderRepo.save(productOrderEntity);

		// convert productOrder entity to productOrder model
		//ProductOrderDTO newProductOrder = new ProductOrderDTO();
		//BeanUtils.copyProperties(newProductOrderEntity, newProductOrder);



//return newProductOrderEntity;
		
	}

	@Override
	public ProductOrderEntity updateProductOrder(int id,ProductOrderDTO productOrderDTO) {
		if(iProductOrderRepo.findById(id).isPresent()) {
			List<ProductEntity> productEntityList = new ArrayList<>();	
			for(int productId: productOrderDTO.getProducts()) {
				if(iProductRepo.findById(productId).isPresent()) {
					productEntityList.add(iProductRepo.findById(productId).get());
				}
				else {
					throw new DoesnotExistsException("Product doesnt exists with id: "+productId);
				}
			}
			ProductOrderEntity productOrderEntity = new ProductOrderEntity();
			
			productOrderEntity.setOrderDate(productOrderDTO.getOrderDate());
			
			productOrderEntity.setProducts(productEntityList);
			productOrderEntity.setOrderStatus(productOrderDTO.getOrderStatus());
			productOrderEntity.setTotalAmount(productOrderDTO.getTotalAmount());
			productOrderEntity.setOrderId(id);
			productOrderEntity = iProductOrderRepo.save(productOrderEntity);
			return productOrderEntity;
		}
		else {
			throw new DoesnotExistsException("Order with the id doesn't exists: "+id);
		}
	}

	@Override
	public ProductOrderEntity deleteProductOrder(int id) {
		if(iProductOrderRepo.findById(id).isPresent()) {
			ProductOrderEntity productOrderEntity = iProductOrderRepo.findById(id).get();
			iProductOrderRepo.deleteById(id);
			return productOrderEntity;
		}
		else {
			throw new DoesnotExistsException("Order with the id doesn't exists: "+id);
		}
	}

	@Override
	public List<ProductOrderEntity> getAllProductOrders() {

		List<ProductOrderEntity> productOrderEntityList = iProductOrderRepo.findAll();
		return productOrderEntityList;
	}

	@Override
	public ProductOrderEntity getProductOrderById(int id) {
		if(iProductOrderRepo.findById(id).isPresent()) {
			ProductOrderEntity productOrderEntity = iProductOrderRepo.findById(id).get();
			return productOrderEntity;
		}
		else {
			throw new DoesnotExistsException("Order with the id doesn't exists: "+id);
		}
	}

}
