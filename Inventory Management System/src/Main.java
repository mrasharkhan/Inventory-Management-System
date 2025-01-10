import java.util.Scanner;
import java.io.IOException;
// This is the Main class where the program is run and selection of tasks is displayed to the user.
// Using do and switch, case statements different tasks are triggered in the Inventory manager class and 
// output is displayed to the user.
// Exceptions are handled using try and catch statement.

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        //These are the choices displayed to the user from 1-13.
        int choice;
        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Category");
            System.out.println("6. Search by Price Range");
            System.out.println("7. Sort by Price");
            System.out.println("8. Sort by Name");
            System.out.println("9. Sort by Date Added");
            System.out.println("10. Display All Products");
            System.out.println("11. Save to File");
            System.out.println("12. Load from File");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline.
            // 1st Case for the user is to Add Product in the Array list Product.
            // All the attributes are being read using Scanner, then using manager.addProduct all the 
            // attributes are added in the Product Array list.
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter SKU: ");
                    String sku = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Date Added (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    manager.addProduct(new Product(sku, name, category, price, quantity, date));
                }
                // 2nd Case Updating the Product.
                // User is asked the sku, then after using manager.updateProduct will add all updated attributes to the 
                // array list.
                case 2 -> {
                    System.out.print("Enter SKU to Update: ");
                    String sku = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter New Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Date Added (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    manager.updateProduct(sku, new Product(sku, name, category, price, quantity, date));
                }
                // Case 3 will delete the product, suer will be asked for the sku and the manager.deleteproduct will
                // delete the product.
                case 3 -> {
                    System.out.print("Enter SKU to Delete: ");
                    String sku = scanner.nextLine();
                    manager.deleteProduct(sku);
                }
                // Case 4 is for searching the product by name, the search by name method is called from inventory 
                // management system, if the name entered by the user is matched the output with the same name in the 
                // Product array list is returned.
                case 4 -> {
                    System.out.print("Enter Name to Search: ");
                    String name = scanner.nextLine();
                    manager.searchByName(name).forEach(System.out::println);
                }
                // Case 5 is for searching by category.
                case 5 -> {
                    System.out.print("Enter Category to Search: ");
                    String category = scanner.nextLine();
                    manager.searchByCategory(category).forEach(System.out::println);
                }
                // Case 6 is for searching by Price Range.
                case 6 -> {
                    System.out.print("Enter Min Price: ");
                    double min = scanner.nextDouble();
                    System.out.print("Enter Max Price: ");
                    double max = scanner.nextDouble();
                    manager.searchByPriceRange(min, max).forEach(System.out::println);
                }
                // Case 7 is sorting by price.
                case 7 -> {
                    manager.sortByPrice();
                    System.out.println("Sorted by Price.");
                    
                }
                // Case 8 is sorting by name.
                case 8 -> {
                    manager.sortByName();
                    System.out.println("Sorted by Name.");
                    
                }
                // Case 9 is sorting by date added.
                case 9 -> {
                    manager.sortByDateAdded();
                    System.out.println("Sorted by Date Added.");
                    
                }
                // Case 10 is single line which displays all products by calling the display product method.
                case 10 -> manager.displayProducts();
                // Case 11  handles saving the product list to a file.
                case 11 -> {
                    System.out.print("Enter Filename to Save: ");
                    String filename = scanner.nextLine();
                    // This try and catch statement handles the exception of naming the file wrongly.
                    // It gives out the error saving to the file.
                    try {
                        manager.saveToFile(filename);
                    } catch (IOException e) {
                        System.out.println("Error saving to file: " + e.getMessage());
                    }
                }
                // Case 12 handles loading the data from the file to the array list in the program.
                case 12 -> {
                    System.out.print("Enter Filename to Load: ");
                    String filename = scanner.nextLine();
                    // This try and catch statement handles the exception if the name is not entered correctly
                    // and does not match the name of the file in the system.
                    // It gives the error loading from file.
                    try {
                        manager.loadFromFile(filename);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error loading from file: " + e.getMessage());
                    }
                }
                case 13 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice."); // This handle if the choice is not between 1-13
                												  // gives output of invalid choice.
            }
        } while (choice != 13); // This while loop keeps the program running until the choice is 13 which is exit.

        scanner.close();
    }
}
