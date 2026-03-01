package testing.exercises;

/**
 * Exercise 1: Basic Assertions
 * 
 * Tasks:
 * 1. Complete the PersonValidator class below
 * 2. Write validation methods using assertions
 * 3. Run with -ea flag: java -ea testing.exercises.Exercise1
 * 
 * The PersonValidator should validate:
 * - Age must be between 0 and 150
 * - Name cannot be null or empty
 * - Email must contain '@' symbol
 */
public class Exercise1 {
    
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Validating Person Data ===\n");
        
        PersonValidator validator = new PersonValidator();
        
        // TODO: Validate a valid person
        System.out.println("Validating valid person...");
        Person validPerson = new Person("Alice", 25, "alice@email.com");
        // Use assertions to verify this person is valid
        
        
        // TODO: Validate invalid age (negative)
        System.out.println("\nValidating person with negative age...");
        Person invalidAge = new Person("Bob", -5, "bob@email.com");
        // This should fail an assertion
        
        
        // TODO: Validate invalid age (too old)
        System.out.println("\nValidating person with age > 150...");
        Person tooOld = new Person("Charlie", 200, "charlie@email.com");
        // This should fail an assertion
        
        
        // TODO: Validate invalid name (null)
        System.out.println("\nValidating person with null name...");
        Person nullName = new Person(null, 30, "null@email.com");
        // This should fail an assertion
        
        
        // TODO: Validate invalid email (no @)
        System.out.println("\nValidating person with invalid email...");
        Person invalidEmail = new Person("Dave", 40, "notanemail");
        // This should fail an assertion
        
        
        System.out.println("\n✓ All validations completed!");
    }
}

class Person {
    private String name;
    private int age;
    private String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
}

class PersonValidator {
    
    // TODO: Implement validateAge method
    // Should validate that age is between 0 and 150
    public void validateAge(int age) {
        // Your code here - use assert
    }
    
    // TODO: Implement validateName method
    // Should validate that name is not null or empty
    public void validateName(String name) {
        // Your code here - use assert
    }
    
    // TODO: Implement validateEmail method
    // Should validate that email contains '@'
    public void validateEmail(String email) {
        // Your code here - use assert
    }
    
    // TODO: Implement validatePerson method
    // Should call all three validation methods
    public void validatePerson(Person person) {
        // Your code here
    }
}
