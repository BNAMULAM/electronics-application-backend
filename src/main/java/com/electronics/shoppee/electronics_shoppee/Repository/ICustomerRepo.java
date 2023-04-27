package com.electronics.shoppee.electronics_shoppee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;

@Repository
public interface ICustomerRepo extends JpaRepository<CustomerEntity,Integer>{ 
}
