package com.bikash.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikash.entity.product.Product;

@Repository
public interface IRepoProduct extends JpaRepository<Product,Integer> {

}
