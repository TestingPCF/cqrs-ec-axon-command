package com.hcl.cqrs.controllers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.cqrs.commands.AddProductToCatalogCommand;
import com.hcl.cqrs.entity.ProductCatalog;
import com.hcl.cqrs.repository.ProductCatalogObjectRepository;
import com.hcl.cqrs.services.CatalogService;

@RestController
public class CatalogApiController {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogApiController.class);

	private final CatalogService catalogService;
	private ProductCatalogObjectRepository repository;

	public CatalogApiController(CatalogService commandGateway, ProductCatalogObjectRepository repository) {
		this.catalogService = commandGateway;
		this.repository = repository;
	}
	
	@GetMapping
	public List<ProductCatalog> findAll(){
		return repository.findAll();
	}

	@PostMapping("/add")
	public CompletableFuture<String> addProductToCatalog(@RequestBody Map<String, String> request) {

		AddProductToCatalogCommand command = new AddProductToCatalogCommand(request.get("id"), request.get("name"));
		LOG.info("Executing command: {}", command);
		return catalogService.addProductToCatalog(command);
	}
}
