package com.streetshawarma.thestreetshawarma.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.streetshawarma.thestreetshawarma.Entity.AdminLogin;

@Repository
public interface LoginRepo extends JpaRepository<AdminLogin, Long>{

	@Query("select a from AdminLogin a where a.userName = :userName")
	public AdminLogin findByUserName(@Param("userName") String userName);
	
}
