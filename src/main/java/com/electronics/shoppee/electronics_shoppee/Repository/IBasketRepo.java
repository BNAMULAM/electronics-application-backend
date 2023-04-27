package com.electronics.shoppee.electronics_shoppee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;

@Repository
public interface IBasketRepo extends JpaRepository<BasketEntity,Integer> {

}
