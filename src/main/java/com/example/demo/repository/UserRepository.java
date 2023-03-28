package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Camera;
import com.example.demo.model.TbUserMaster;


public interface UserRepository extends JpaRepository<TbUserMaster, Long> {
	
	@Query(value = "select * from user where email =:email and password=:password", nativeQuery = true)
	TbUserMaster findByEmailAddressAndPassword(@Param("email")String email,@Param("password")String password);

}
