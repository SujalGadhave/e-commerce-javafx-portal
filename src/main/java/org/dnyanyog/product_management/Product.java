package org.dnyanyog.product_management;

public class Product {
	    private Long productId;
	    private String name;
	    private String quantity;
	    private String price;

	    public Product(Long productId, String name, String quantity, String price) {
	        this.productId = productId;
	        this.name = name;
	        this.quantity = quantity;
	        this.price = price;
	    }

	    public Long getProductId() {
	        return productId;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getQuantity() {
	        return quantity;
	    }

	    public String getPrice() {
	        return price;
	    }
	}

