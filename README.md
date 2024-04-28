Summary:
Implement a RESTful API for a product catalogue system using Java, with MongoDB integration for storage.
Define a Product entity with nested attributes. Create endpoints for CRUD operations, search, pagination, and rating. 
Documentation should cover API endpoints, data model, database setup, and include clear setup instructions. 
Evaluation criteria include data model complexity handling, code quality, effective documentation, and proper database usage. 

API Documentation:

•	GET All Products-->
•	Endpoint: http://localhost:8080/Products/getAll
•	Method: GET
•	Description: Retrieve all products
•	Request Format: No request parameters
•	Response Format: JSON Array of Product Objects

•	Add Product-->
•	Endpoint: http://localhost:8080/Products
•	Method: POST
•	Description: Add a new product
•	Request Format: JSON Object representing the new product
•	Response Format: JSON Object representing the added product

•	Delete Product-->
•	Endpoint: http://localhost:8080/Products/{id}
•	Method: DELETE
•	Description: Delete a product by ID
•	Request Format: Path parameter {id} representing the product ID to be deleted
•	Response Format: Success message if deletion is successful


•	Update Product-->
•	Endpoint: http://localhost:8080/Products/{id}
•	Method: PUT
•	Description: Update a product by ID
•	Request Format: Path parameter {id} representing the product ID to be updated, along with JSON Object containing updated product details
•	Response Format: JSON Object representing the updated product

Data Model:
json
Copy code
{
  "id": "string",
  "name": "string",
  "description": "string",
  "price": "number",
  "categories": ["string"],
  "attributes": [{"key": "string", "value": "string"}],
  "availability": {"inStock": "boolean", "quantity": "number"},
  "ratings": [{"userId": "string", "rating": "number", "comments": "string"}]
}

Database Setup:
Software: MongoDB
Database Name: LeadToRev
