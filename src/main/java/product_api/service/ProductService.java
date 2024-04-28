package product_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import product_api.Service.Autowired;
import product_api.entity.Product;
import product_api.entity.Product.Rating;
import product_api.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	// Method to retrieve all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
		}
	
	// Method to retrieve a product by ID
	public Product getProductById(Long id) {
	    String idStr = String.valueOf(id);
	    return productRepository.findById(idStr).orElse(null);
	}
	
	// Method to create a new product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	// Method to delete a product by ID
	public void deleteProduct(String id) {
	    productRepository.deleteById(id);
	  }
	
	// Method to update an existing product
	public Product updateProduct(String id, Product product) {
	    Product existingProduct = productRepository.findById(id).orElse(null);
	    if (existingProduct != null) {
	      existingProduct.setName(product.getName());
	      existingProduct.setDescription(product.getDescription());
	      existingProduct.setPrice(product.getPrice());
	      existingProduct.setCategories(product.getCategories());
	      existingProduct.setAttributes(product.getAttributes());
	      existingProduct.setAvailability(product.getAvailability());
	      existingProduct.setRatings(product.getRatings());
	      return productRepository.save(existingProduct);
	    } else {
	      return null;
	    }
	  }
	
	
	// Method to rate a product
	public Product rateProduct(Rating rating, Long productId) {
	    String productIdStr = String.valueOf(productId);
	    Product product = productRepository.findById(productIdStr).orElseThrow(() -> new RuntimeException("Product not found"));
	    // update product's ratings array with the new rating
	    product.getRatings().add(rating);
	    productRepository.save(product);
	    Product updatedProduct = productRepository.save(product);
	    return updatedProduct;
	}
	
	
}
