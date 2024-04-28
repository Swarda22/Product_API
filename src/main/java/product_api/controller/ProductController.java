package product_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import product_api.entity.Product;
import product_api.entity.Product.Rating;
import product_api.service.ProductService;


@RestController
@RequestMapping("/Products")
public class ProductController {
	
	@Autowired
	private  ProductService productService;
	
	// End point to retrieve all products
	@GetMapping("/getAll")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	// End point to create a new product
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product createProduct = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
	}

	// End point to update an existing product
	 @PutMapping("/{id}")
	  public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
	    Product updatedProduct = productService.updateProduct(id, product);
	    if (updatedProduct != null) {
	      return ResponseEntity.ok(updatedProduct);
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }
	 
	// End point to delete a product by ID
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
	   // Delete the product with the specified id
	   productService.deleteProduct(id);

	   // Return a 204 No Content response
	   return ResponseEntity.noContent().build();
	 }
	 

	// End point to rate a product
	 @PostMapping("/{id}/rating")
	 public Product rateProduct(@PathVariable Long id, @RequestBody Rating rating) {
		 Product updatedProduct = productService.rateProduct(rating, id);
		 return productService.rateProduct(rating, id);
	 }
}





