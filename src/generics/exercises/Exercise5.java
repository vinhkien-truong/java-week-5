package generics.exercises;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercise 4 (Comprehensive Practice)
 * 
 * Complete ALL the following tasks to practice everything you learned:
 * 
 * 1. Create a generic class Box<T> with:
 *    - Field: T value
 *    - Constructor that takes a value
 *    - Getter for value
 *    - toString() method
 * 
 * 2. Create Box<String> and Box<Integer> instances and print them
 * 
 * 3. Write a static method printAll(List<?> items) that prints each element
 * 
 * 4. Write a static method addDefaults(List<? super Integer> numbers)
 *    that adds integers 1, 2, 3 to the list
 * 
 * 5. Write a static method sumNumbers(List<? extends Number> numbers)
 *    that returns the sum as double
 * 
 * 6. Run all methods in main()
 */
public class Exercise5 {
    
    public static void main(String[] args) {
        System.out.println("=== Using Box Class ===\n");
;
        
        // TODO: Task 2 - Create and use Box instances
        Box<String> stringBox = new Box<>("Hello Generics");
        Box<Integer> intBox = new Box<>(123);
        System.out.println(stringBox);
        System.out.println(intBox);
        
        System.out.println("\n=== Using printAll ===\n");
        
        // TODO: Task 3 - Call printAll with different lists

        List<String> stringList = List.of("Apple", "Banana", "Cherry");
        List<Integer> intList = List.of(10, 20, 30);
        printAll(stringList);
        printAll(intList);
        
        
        System.out.println("\n=== Using addDefaults ===\n");
        
        // TODO: Task 4 - Call addDefaults
        List<Integer> numbers = new ArrayList<>();
        addDefaults(numbers);
        System.out.println("After adding defaults: " + numbers);
        
        
        System.out.println("\n=== Using sumNumbers ===\n");
        
        // TODO: Task 5 - Call sumNumbers
        sumNumbers(numbers);
        List<Double> doubleNumbers = List.of(1.5, 2.5, 3.5);
        System.out.println("Sum of integer list: " + sumNumbers(numbers));
        System.out.println("Sum of double list: " + sumNumbers(doubleNumbers));
        
    }
    
    // TODO: Task 3 - Implement printAll method
    public static void printAll(List<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }
    
    
    // TODO: Task 4 - Implement addDefaults method
    public static void addDefaults(List<? super Integer> numbers) {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    
    // TODO: Task 5 - Implement sumNumbers method
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
}

// TODO: Task 1 - Create Box<T> class here

class Box<T> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "Box{" + "value=" + value + '}';
    }
}

