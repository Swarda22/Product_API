package product_api.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import product_api.entity.Document;

import product_api.entity.Product.Attribute;
import product_api.entity.Product.Availability;
import product_api.entity.Product.Rating;
@Document(collection = "Products")
public class Product {
		@Id
		private String id;
		private String name;
		private String description;
		private double price;
		private List<String> categories;
		private List<Attribute> attributes;
		private Availability availability;
		private List<Rating> ratings;
		
		public Product(String id,String name,String description,double price,
				List<String> categories,List<Attribute> attributes,Availability availability,List<Rating> ratings) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.categories = categories;
			this.attributes = attributes;
			this.availability = availability;
			this.ratings = ratings;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		public List<Attribute> getAttributes() {
			return attributes;
		}

		public void setAttributes(List<Attribute> attributes) {
			this.attributes = attributes;
		}

		public Availability getAvailability() {
			return availability;
		}

		public void setAvailability(Availability availability) {
			this.availability = availability;
		}

		public List<Rating> getRatings() {
			return ratings;
		}

		public void setRatings(List<Rating> ratings) {
			this.ratings = ratings;
		}
		
		public static class Attribute{
			private String key;
			private String value;
			public Attribute(String key, String value) {
				super();
				this.key = key;
				this.value = value;
			}
			public String getKey() {
				return key;
			}
			public void setKey(String key) {
				this.key = key;
			}
			public String getValue() {
				return value;
			}
			public void setValue(String value) {
				this.value = value;
			}		
		}
		
		//Nested class Availability
		public static class Availability{
			private boolean inStock;
			private int quantity;
			public Availability(boolean inStock, int quantity) {
				super();
				this.inStock = inStock;
				this.quantity = quantity;
			}
			public boolean isInStock() {
				return inStock;
			}
			public void setInStock(boolean inStock) {
				this.inStock = inStock;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}		
		}//end of nested class
		
		//Nested class Rating
		public static class Rating{
			private String userId;
			private int rating;
			private String comments;
			public Rating(String userId, int rating, String comments) {
				super();
				this.userId = userId;
				this.rating = rating;
				this.comments = comments;
			}
			public String getUserId() {
				return userId;
			}
			public void setUserId(String userId) {
				this.userId = userId;
			}
			public int getRating() {
				return rating;
			}
			public void setRating(int rating) {
				this.rating = rating;
			}
			public String getComments() {
				return comments;
			}
			public void setComments(String comments) {
				this.comments = comments;
			}		
		}//end of nested class
}
