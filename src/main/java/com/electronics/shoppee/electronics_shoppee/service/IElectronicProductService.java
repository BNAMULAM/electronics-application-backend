package com.electronics.shoppee.electronics_shoppee.service;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.ProductEntity;
import com.electronics.shoppee.electronics_shoppee.model.ProducDTO;

public interface IElectronicProductService {

	ProductEntity addElectronicProduct(ProducDTO producDTO);

	ProductEntity updateElectronicProduct(int id, ProducDTO producDTO);

	ProductEntity deleteElectronicProduct(int id);

	ProductEntity getElectronicProductById(int id);

	List<ProductEntity> getAllElectronicProduct();

}
