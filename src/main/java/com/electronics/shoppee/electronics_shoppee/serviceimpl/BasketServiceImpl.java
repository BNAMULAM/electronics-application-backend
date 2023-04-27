package com.electronics.shoppee.electronics_shoppee.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IBasketRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IProductRepo;
import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductEntity;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.exception.UnhandledException;
import com.electronics.shoppee.electronics_shoppee.model.BasketDTO;
import com.electronics.shoppee.electronics_shoppee.service.IBasketService;

@Service
public class BasketServiceImpl implements IBasketService {

	@Autowired
	private IBasketRepo iBasketRepo;

	@Autowired
	private IProductRepo iProductRepo;
	
	@Override
	public BasketEntity addBasket(BasketDTO basketDTO) {
		List<ProductEntity> productEntityList = new ArrayList<>();	
		for(int productId: basketDTO.getProductIds()) {
			if(iProductRepo.findById(productId).isPresent()) {
				productEntityList.add(iProductRepo.findById(productId).get());
			}
			else {
				throw new DoesnotExistsException("Product doesnt exists with id: "+productId);
			}
		}
		try {
			BasketEntity basketEntity = new BasketEntity();
			
			basketEntity.setProductCount(basketDTO.getProductCount());
			
			basketEntity.setProducts(productEntityList);
			basketEntity.setTotal(basketDTO.getTotal());

			basketEntity = iBasketRepo.save(basketEntity);
			return basketEntity;
		}
		catch(Exception e) {
			throw new UnhandledException("something went wrong");
		}
	}

	@Override
	public BasketEntity updateBasket(int id, BasketDTO basketDTO) {
		if(iBasketRepo.findById(id).isPresent()) {
			List<ProductEntity> productEntityList = new ArrayList<>();	
			for(int productId: basketDTO.getProductIds()) {
				if(iProductRepo.findById(productId).isPresent()) {
					productEntityList.add(iProductRepo.findById(productId).get());
				}
				else {
					throw new DoesnotExistsException("Product doesnt exists with id: "+productId);
				}
			}
			BasketEntity basketEntity = new BasketEntity(); 
			basketEntity.setProductCount(basketDTO.getProductCount());
			basketEntity.setBasketId(id);
			basketEntity.setProducts(productEntityList);
			basketEntity.setTotal(basketDTO.getTotal());

			basketEntity = iBasketRepo.save(basketEntity);
			return basketEntity;
		}
		else {
			throw new DoesnotExistsException("Basket doesnt exists with id: "+id);
		}
	}

	@Override
	public BasketEntity deleteBasket(int id) {
		if(iBasketRepo.findById(id).isPresent()) {
			BasketEntity basketEntity = iBasketRepo.findById(id).get();
			iBasketRepo.deleteById(id);
			return basketEntity;
		}
		else {
			throw new DoesnotExistsException("Basket doesnt exists with id: "+id);
		}
	}

	@Override
	public BasketEntity getBasketById(int id) {
		if(iBasketRepo.findById(id).isPresent()) {
			BasketEntity basketEntity = iBasketRepo.findById(id).get();
			return basketEntity;
		}
		else {
			throw new DoesnotExistsException("Basket doesnt exists with id: "+id);
		}
	}

	@Override
	public List<BasketEntity> getAllBaskets() {

		List<BasketEntity> basketEntityList = iBasketRepo.findAll();
		return basketEntityList;
	}

}
