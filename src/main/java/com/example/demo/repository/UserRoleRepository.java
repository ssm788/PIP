package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.TbUserMaster;
import com.example.demo.model.UserRoleMapping;

public interface UserRoleRepository extends JpaRepository<UserRoleMapping, Long> {
	
	@Query(value = "select * from tb_user_role_mapping where iduser =:iduser", nativeQuery = true)
	UserRoleMapping getUserRole(@Param("iduser")int iduser);

}