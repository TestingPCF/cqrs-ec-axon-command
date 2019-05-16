package com.hcl.cqrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.cqrs.entity.ProductCatalog;

@Repository
public interface ProductCatalogObjectRepository extends JpaRepository<ProductCatalog, String>{

}
