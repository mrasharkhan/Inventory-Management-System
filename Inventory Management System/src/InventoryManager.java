import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// This class perform all the task necessary for Inventory Management System on the Product Class
public class InventoryManager {
    private List<Product> inventory = new ArrayList<>();

    // Add Product
    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println("Product added successfully!");
    }

    // Update Product
    //Product can be updated on the basis of sku, for matching sku in the array list all 
    //the attributes of Product can be updated
    public void updateProduct(String sku, Product updatedProduct) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getSku().equalsIgnoreCase(sku)) {
                inventory.set(i, updatedProduct);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // Delete Product
    //Deleting the product after matching the sku
    public void deleteProduct(String sku) {
        inventory.removeIf(product -> product.getSku().equalsIgnoreCase(sku));
        System.out.println("Product deleted successfully!");
    }

    // Search Products
    // Searching by Category
    public List<Product> searchByCategory(String category) {
        return inventory.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
    // Searching by Name
    public List<Product> searchByName(String name) {
        return inventory.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
 
    // Searching by price range (Min Price & Max Price)
    public List<Product> searchByPriceRange(double minPrice, double maxPrice) {
        return inventory.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Sort Products (Ascending Order)
    // Sorting Products by Price
    public void sortByPrice() {
        inventory.sort(Comparator.comparingDouble(Product::getPrice));
    }
    // Sorting by Name
    public void sortByName() {
        inventory.sort(Comparator.comparing(Product::getName));
    }
    // Sorting by the Date Added
    public void sortByDateAdded() {
        inventory.sort(Comparator.comparing(Product::getDateAdded));
    }

    // Display All Products
    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            inventory.forEach(System.out::println);
        }
    }

    // Save to File
    // Using Object Output Stream the inventory is saved in a file, So that all products can
    // be loaded again after running the program again.
    // Try and catch statement handles the exception of naming file wrong.
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(inventory);
            System.out.println("Data saved to file.");
        }
    }

    // Load from File
    // Loading the file saved before in the Array list
    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            inventory = (List<Product>) ois.readObject();
            System.out.println("Data loaded from file.");
        }
    }
    }




