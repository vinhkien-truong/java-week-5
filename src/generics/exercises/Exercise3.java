package generics.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 3: Wildcards and PECS
 * 
 * Tasks:
 * 1. Write a method printList(List<?> list) that prints any list
 *    - Try with different types of lists
 * 
 * 2. Write a method sumList(List<? extends Number> numbers) that calculates
 *    the sum of all numbers
 *    - Try with List<Integer>, List<Double>, and mixed List<Number>
 * 
 * 3. Write a method addThreeIntegers(List<? super Integer> list) that adds
 *    the numbers 10, 20, 30 to the list
 *    - Try with List<Integer>, List<Number>, and List<Object>
 * 
 * 4. Write a method copy(List<? extends T> source, List<? super T> dest)
 *    that copies all elements from source to destination
 *    - Demonstrate PECS principle
 *    - Try by copying List<Integer> to List<Number>
 *    - Try by copying List<Double> to List<Object>
 * 
 * 5. Write a method maxOfTwo(List<? extends Number> list1, 
 *                            List<? extends Number> list2)
 *    that returns the maximum element from both lists combined
 *    - Try with different number types
 * 
 * 6. BONUS: Create a method that demonstrates why you can't add to
 *    List<? extends Number> (producer)
 *    Write a comment explaining why
 */
public class Exercise3 {
    
    public static void main(String[] args) {
        System.out.println("=== Task 1: Print Any List ===\n");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        List<String> str = Arrays.asList("aaa","kko","dnd");

        // TODO: Call printList with different types
        printList(integers);
        printList(doubles);
        printList(str);
        System.out.println("\n=== Task 2: Sum Numbers ===\n");
        
        // TODO: Call sumList
        System.out.println(sumList(integers));
        System.out.println(sumList(doubles));

        
        
        System.out.println("\n=== Task 3: Add Integers ===\n");
        
        // TODO: Call addThreeIntegers with different list types
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        addThreeIntegers(intList);
        addThreeIntegers(numList);
        addThreeIntegers(objList);
        System.out.println(intList);
        System.out.println(numList);
        System.out.println(objList);
        System.out.println("\n=== Task 4: Copy Lists (PECS) ===\n");
        
        // TODO: Demonstrate PECS with copy method
        List<Integer> sourceInt = Arrays.asList(1, 2, 3);
        List<Number> destNum = new ArrayList<>();
        copy(sourceInt, destNum);
        System.out.println("After copying Integer to Number: " + destNum);
        
        
        System.out.println("\n=== Task 5: Max of Two Lists ===\n");
        
        // TODO: Call maxOfTwo method
        List<Integer> intList1 = Arrays.asList(10, 20, 30);
        List<Double> doubleList1 = Arrays.asList(15.5, 25.5, 5.5);
        Number max = maxOfTwo(intList1, doubleList1);
        System.out.println("Max of two lists: " + max);
        
        
        System.out.println("\n=== Task 6: BONUS - Why Can't Add? ===\n");
        
        // TODO: Try to explain and demonstrate
        List<Double> wildcardList = Arrays.asList(1.0, 2.0, 3.0);
        demonstrateWhyCantAdd(wildcardList);
        
    }
    
    // TODO: Task 1 - Implement printList
    public static <T> void printList(List<T> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        List<T> arrayList = new ArrayList<>(list);
        for (T element : arrayList) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // TODO: Task 2 - Implement sumList
    public static <T extends Number> double sumList(List<? extends Number> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException("list cannot be null or empty");
        }
        double result = 0;

        for (Number element : numbers) {
            result += element.doubleValue();
        }
        return result;
    }
    
    
    // TODO: Task 3 - Implement addThreeIntegers
    public static <T extends Number> void addThreeIntegers(List<? super Integer> list)  {
        list.add(3);
        list.add(6);
        list.add(2);
    }
    
    
    // TODO: Task 4 - Implement copy method
    public static <T> void copy(List<? extends T> source, List<? super T> dest) {
        if (source == null || dest == null) {
            throw new IllegalArgumentException("Source and destination lists cannot be null");
        }
        for (T element : source) {
            dest.add(element);
        }
    }
    
    
    // TODO: Task 5 - Implement maxOfTwo
    public static <T extends Number & Comparable<T>> T maxOfTwo(List<? extends Number> list1, List<? extends Number> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()) {
            throw new IllegalArgumentException("Lists cannot be null or empty");
        }
        
        T max = (T) Double.valueOf(Double.NEGATIVE_INFINITY);
        
        for (Number num : list1) {
            if (num.doubleValue() > max.doubleValue()) {
                max = (T) num;
            }
        }
        
        for (Number num : list2) {
            if (num.doubleValue() > max.doubleValue()) {
                max = (T) num;
            }
        }
        
        return max;
    }
    
    
    // TODO: Task 6 - BONUS
    // You cannot add to List<? extends Number> because it is a producer of Number.
    // The wildcard ? extends Number means 
    // that the list can hold any type that is a subclass of 
    // Number (like Integer, Double, etc.), 
    // but you don't know which specific type it is.
    // Therefore, you cannot safely add any specific type of Number to the list, 
    // because it might violate the type safety of the list. For example, 
    // if you try to add an Integer to a List<? extends Number> 
    // that is actually a List<Double>, it would cause a ClassCastException 
    // at runtime. This is why you can only read from a List<? extends Number> 
    // (it produces Number), but you cannot add to it (it is not a consumer).

    public static void demonstrateWhyCantAdd(List<? extends Number> list) {
         //list.add(10); // Cannot add to List<? extends Number>
    }



    
}
