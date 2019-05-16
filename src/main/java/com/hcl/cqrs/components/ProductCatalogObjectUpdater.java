package com.hcl.cqrs.components;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.hcl.cqrs.entity.ProductCatalog;
import com.hcl.cqrs.events.ProductAddedEvent;
import com.hcl.cqrs.repository.ProductCatalogObjectRepository;

@Component
public class ProductCatalogObjectUpdater {

	private ProductCatalogObjectRepository repository;

	public ProductCatalogObjectUpdater(ProductCatalogObjectRepository repository) {
		this.repository = repository;
	}
	
	@EventHandler
	public void on (ProductAddedEvent event) {
		repository.save(new ProductCatalog(event.getId(),event.getName()));
	}
}
