import java.io.Serializable;

	// Defining class Product with an object Product having attributes 
	// like sku, name, category, price and Date Added.

public class Product implements Serializable {
    private String sku;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private String dateAdded;
    //Constructor method for the object Product
    public Product(String sku, String name, String category, double price, int quantity, String dateAdded) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity= quantity;
        this.dateAdded = dateAdded;
    }

    // Getters and Setters for attributes of Product
    public String getSku() { return sku; } 
    public void setSku(String sku) { this.sku = sku; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }

    @Override
    public String toString() {
        return String.format("SKU: %s, Name: %s, Category: %s, Price: %.2f, Quantity %d, Date Added: %s",
                sku, name, category, price, quantity, dateAdded);
    }
}


