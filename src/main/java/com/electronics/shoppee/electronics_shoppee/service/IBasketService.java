package com.electronics.shoppee.electronics_shoppee.service;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
import com.electronics.shoppee.electronics_shoppee.model.BasketDTO;

public interface IBasketService {

	BasketEntity addBasket(BasketDTO basketDTO);

	BasketEntity updateBasket(int id, BasketDTO basketDTO);

	BasketEntity deleteBasket(int id);

	BasketEntity getBasketById(int id);

	List<BasketEntity> getAllBaskets();

}
