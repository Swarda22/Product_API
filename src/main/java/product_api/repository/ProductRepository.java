package product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import product_api.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
}

