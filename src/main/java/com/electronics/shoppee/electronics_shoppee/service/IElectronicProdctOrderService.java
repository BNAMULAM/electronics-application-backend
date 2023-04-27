package com.electronics.shoppee.electronics_shoppee.service;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.ProductOrderEntity;
import com.electronics.shoppee.electronics_shoppee.model.ProductOrderDTO;

public interface IElectronicProdctOrderService {

	ProductOrderEntity addProductOrder(ProductOrderDTO productOrderDTO);

	ProductOrderEntity updateProductOrder(int id, ProductOrderDTO productOrderDTOy);

	ProductOrderEntity deleteProductOrder(int id);

	List<ProductOrderEntity> getAllProductOrders();

	ProductOrderEntity getProductOrderById(int id);

}
