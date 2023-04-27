package com.electronics.shoppee.electronics_shoppee.service;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.ProductTypeEntity;
import com.electronics.shoppee.electronics_shoppee.model.ProductTypeDTO;

public interface IElectronicProductTypeService {

	ProductTypeEntity addElectronicProductType(ProductTypeDTO productTypeDTO);

	ProductTypeEntity updateElectronicProductType(int id, ProductTypeDTO productTypeDTO);

	ProductTypeEntity deleteElectronicProductType(int id);

	ProductTypeEntity getElectronicProductTypeById(int id);

	List<ProductTypeEntity> getElectronicProductTypeById();

}
