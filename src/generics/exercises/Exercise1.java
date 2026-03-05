package generics.exercises;

/**
 * Exercise 1: Basic Generic Classes
 * 
 * Tasks:
 * 1. Create a generic class Container<T> that holds a single value
 *    - Add a constructor that takes a value
 *    - Add getValue() and setValue() methods
 *    - Add an isEmpty() method that returns true if value is null
 * 
 * 2. In main(), create instances for different types:
 *    - Container<String> with value "Hello"
 *    - Container<Integer> with value 100
 *    - Container<Boolean> with value true
 *    - Print all values
 * 
 * 3. Create a generic class Pair<K, V> with two values
 *    - Add getKey() and getValue() methods
 *    - Add a swap() method that returns a new Pair<V, K> with swapped values
 * 
 * 4. Try Pair with:
 *    - Pair<String, Integer> for ("age", 25)
 *    - Swap it and print both pairs
 */
public class Exercise1 {
    
    public static void main(String[] args) {
        System.out.println("=== Task 1 & 2: Container Class ===\n");
        
        // TODO: Create Container instances and use them
        Container<String> container = new Container<>("Hello");
        Container<Integer> intContainer = new Container<>(100);
        Container<Boolean> boolContainer = new Container<>(true);
        System.out.println("get value : " +container.getValue());
        container.setValue("ppppp");
        System.out.println("set value :  " + container.getValue());
        System.out.println("is empty : " + container.isEmpty());

        System.out.println("intContainer value : " + intContainer.getValue());
        System.out.println("intContainer is empty : " + intContainer.isEmpty());
        System.out.println("boolContainer value : " + boolContainer.getValue());
        System.out.println("boolContainer is empty : " + boolContainer.isEmpty());

        
        System.out.println("\n=== Task 3 & 4: Pair Class ===\n");
        
        // TODO: Create Pair instances, try swap() method
        
        Pair<String, Integer> nameAge = new Pair<>("age", 25);
        System.out.println("Original pair: " + nameAge);
        System.out.println("Original pair: " + nameAge.getKey());
        Pair<Integer, String> swapped = nameAge.swap();
        System.out.println("Swapped pair: " + swapped); 
        System.out.println("Swapped pair: " + swapped.getKey()); 
    }
}

// TODO: Task 1 - Create Container<T> class here
class Container<T> {
    private T value;
    
    public Container(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == null;
    }
    
    @Override
    public String toString() {
        return "Container{" + value + "}";
    }
}

// TODO: Task 3 - Create Pair<K, V> class here
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
    
    public Pair<V, K> swap() { // https://stackoverflow.com/questions/77615959/how-to-swap-different-type-of-generic-in-java
        return new Pair<>(value, key);
    }
    
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}