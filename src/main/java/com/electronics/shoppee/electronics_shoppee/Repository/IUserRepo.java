package com.electronics.shoppee.electronics_shoppee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;

@Repository
public interface IUserRepo extends JpaRepository<UserEntity,String> {

	UserEntity findByUsername(String username);

}
