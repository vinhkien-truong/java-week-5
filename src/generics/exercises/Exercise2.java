package generics.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 2: Generic Methods and Bounded Types
 * 
 * Tasks:
 * 1. Write a generic method printArray(T[] array) that prints all elements
 *    - Try it with String[], Integer[], and Double[] arrays
 * 
 * 2. Write a generic method reverse(T[] array) that returns a new array
 *    with elements in reverse order
 *    - Try with different array types
 * 
 * 3. Write a method findMin(List<? extends Number> numbers) that returns
 *    the smallest number as a double
 *    - Try with List<Integer> and List<Double>
 * 
 * 4. Create a generic class Calculator<T extends Number>
 *    - Add add(), subtract(), multiply() methods that work with T
 *    - Return results as double
 *    - Try with Integer and Double
 * 
 * 5. Write a method countGreaterThan(T[] array, T element) that counts
 *    how many elements are greater than the given element
 *    - T must be Comparable
 *    - Try with different types
 */
public class Exercise2 {
    
    public static void main(String[] args) {
        System.out.println("=== Task 1: Print Array ===\n");
        
        // TODO: Call printArray method
        String[] words = {"Hello", "World", "Java"};
        Integer[] numbers = {1, 2, 3, 4, 5};
        printArray(words);
        printArray(numbers);
        
        
        System.out.println("\n=== Task 2: Reverse Array ===\n");
        
        // TODO: Call reverse method
        reverse(words);
        reverse(numbers);
        System.out.println("\n=== Task 3: Find Minimum ===\n");
        
        // TODO: Call findMin method
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(5);
        integers.add(20);
        integers.add(3);

        System.out.println(findMin(integers));
        
        System.out.println("\n=== Task 4: Calculator ===\n");
        
        // TODO: Create and use Calculator instances
        Calculator<Integer> intCalc = new Calculator<>();
        System.out.println("Integer add: " + intCalc.add(5, 10));
        System.out.println("Integer subtract: " + intCalc.subtract(10, 5));
        System.out.println("Integer multiply: " + intCalc.multiply(5, 10));
        
        
        System.out.println("\n=== Task 5: Count Greater Than ===\n");
        
        // TODO: Call countGreaterThan method
        String[] names = {"Truong", "Vinh", "Kien", "Dat"};
        int count = countGreaterThan(names, "lng");
        System.out.println("Count of names greater than 'Lng': " + count);

        
    }
    
    // TODO: Task 1 - Implement printArray method
    public static <T> void printArray(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // TODO: Task 2 - Implement reverse method
    public static <T> void reverse(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    
    // TODO: Task 3 - Implement findMin method
    
    public static <T extends Comparable<T>> double findMin(List<? extends Number> numbers){
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        double min = numbers.get(0).doubleValue();
        for (Number num : numbers) {
            if (num.doubleValue() < min) {
                min = num.doubleValue();
            }
        }
        return min;
    }
    
    
    // TODO: Task 5 - Implement countGreaterThan method
    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T element) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int count = 0;
        for (T item : array) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
    
}

// TODO: Task 4 - Create Calculator<T extends Number> class here

class Calculator<T extends Number> {
    
    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    
    public double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }
    
    public double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }
}