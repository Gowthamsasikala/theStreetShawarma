package com.streetshawarma.thestreetshawarma.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.streetshawarma.thestreetshawarma.Entity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long>{

}
