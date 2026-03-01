package testing.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 3: Arrange-Act-Assert Pattern
 * 
 * Demonstrates the AAA pattern for writing clear, organized tests.
 * This is the standard pattern used in professional testing.
 */
public class Example3 {
    
    public static void main(String[] args) {
        System.out.println("=== Arrange-Act-Assert Pattern ===\n");
        
        runAllTests();
    }
    
    public static void runAllTests() {
        int passed = 0;
        int total = 0;
        
        // Run each test individually
        total++; if (addItemToCart_increasesCartSize()) passed++;
        total++; if (removeItemFromCart_decreasesCartSize()) passed++;
        total++; if (calculateTotal_sumsAllItemPrices()) passed++;
        total++; if (applyDiscount_reducesTotal()) passed++;
        total++; if (clearCart_removesAllItems()) passed++;
        
        // Print summary
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Results: " + passed + "/" + total + " tests passed");
        System.out.println("=".repeat(50));
    }
    
    // ========== Test Methods ==========
    
    public static boolean addItemToCart_increasesCartSize() {
        String testName = "Adding item increases cart size";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE - Set up test data
            ShoppingCart cart = new ShoppingCart();
            Item item = new Item("Book", 15.99);
            int initialSize = cart.getItemCount();
            
            // ACT - Perform the action
            cart.addItem(item);
            
            // ASSERT - Verify the result
            int finalSize = cart.getItemCount();
            if (finalSize != initialSize + 1) {
                throw new AssertionError("Expected size to increase by 1");
            }
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
    
    public static boolean removeItemFromCart_decreasesCartSize() {
        String testName = "Removing item decreases cart size";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE
            ShoppingCart cart = new ShoppingCart();
            Item item = new Item("Laptop", 999.99);
            cart.addItem(item);
            int sizeAfterAdding = cart.getItemCount();
            
            // ACT
            cart.removeItem(item);
            
            // ASSERT
            int finalSize = cart.getItemCount();
            if (finalSize != sizeAfterAdding - 1) {
                throw new AssertionError("Expected size to decrease by 1");
            }
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
    
    public static boolean calculateTotal_sumsAllItemPrices() {
        String testName = "Calculate total sums all prices";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE
            ShoppingCart cart = new ShoppingCart();
            cart.addItem(new Item("Book", 10.00));
            cart.addItem(new Item("Pen", 2.00));
            cart.addItem(new Item("Notebook", 5.00));
            double expectedTotal = 17.00;
            
            // ACT
            double actualTotal = cart.calculateTotal();
            
            // ASSERT
            if (Math.abs(actualTotal - expectedTotal) > 0.01) {
                throw new AssertionError(
                    "Expected: " + expectedTotal + ", but got: " + actualTotal);
            }
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
    
    public static boolean applyDiscount_reducesTotal() {
        String testName = "Applying discount reduces total";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE
            ShoppingCart cart = new ShoppingCart();
            cart.addItem(new Item("Item", 100.00));
            double originalTotal = cart.calculateTotal();
            double discountPercent = 10.0;
            
            // ACT
            cart.applyDiscount(discountPercent);
            double discountedTotal = cart.calculateTotal();
            
            // ASSERT
            double expectedTotal = originalTotal * 0.9; // 10% off
            if (Math.abs(discountedTotal - expectedTotal) > 0.01) {
                throw new AssertionError(
                    "Expected: " + expectedTotal + ", but got: " + discountedTotal);
            }
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
    
    public static boolean clearCart_removesAllItems() {
        String testName = "Clearing cart removes all items";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE
            ShoppingCart cart = new ShoppingCart();
            cart.addItem(new Item("Item1", 10.00));
            cart.addItem(new Item("Item2", 20.00));
            cart.addItem(new Item("Item3", 30.00));
            
            // ACT
            cart.clear();
            
            // ASSERT
            if (cart.getItemCount() != 0) {
                throw new AssertionError(
                    "Expected 0 items after clear, but got: " + cart.getItemCount());
            }
            if (cart.calculateTotal() != 0.0) {
                throw new AssertionError(
                    "Expected total of 0.0 after clear, but got: " + cart.calculateTotal());
            }
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
}

// ========== Classes to be tested ==========

class Item {
    private String name;
    private double price;
    
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Item> items;
    private double discountPercent;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.discountPercent = 0.0;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public int getItemCount() {
        return items.size();
    }
    
    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total * (1 - discountPercent / 100);
    }
    
    public void applyDiscount(double percent) {
        this.discountPercent = percent;
    }
    
    public void clear() {
        items.clear();
    }
}
