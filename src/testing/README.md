# Testing in Java (Without External Libraries)

This module teaches fundamental testing concepts using Java's built-in features.

---

## Why Testing Matters

Testing ensures your code works correctly and helps catch bugs early. Good tests:
- Verify that your code does what it's supposed to do
- Catch bugs before they reach production
- Make refactoring safer
- Document how your code should work

---

## Java Built-in Testing Features

### 1. Assertions (`assert`)

Assertions are simple checks that throw `AssertionError` if a condition is false.

**Syntax:**
```java
assert condition;
assert condition : "Error message";
```

**Example:**
```java
public class Calculator {
    public int add(int a, int b) {
        int result = a + b;
        assert result >= a && result >= b : "Addition overflow";
        return result;
    }
}
```

**Important:** Assertions must be enabled at runtime:
```bash
java -ea YourClass    # -ea means "enable assertions"
```

---

### 2. Manual Testing Methods

You can write your own testing methods without external libraries:

```java
public class SimpleTest {
    
    public static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + 
                " - Expected: " + expected + ", but got: " + actual);
        }
    }
    
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
    
    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }
}
```

---

## Testing Best Practices

### 1. Test One Thing at a Time

```java
public void validateAddition() {
    Calculator calc = new Calculator();
    
    // Test positive numbers
    assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    
    // Test negative numbers
    assertEquals(-5, calc.add(-2, -3), "-2 + -3 should equal -5");
    
    // Test zero
    assertEquals(5, calc.add(5, 0), "5 + 0 should equal 5");
}
```

### 2. Use Descriptive Names

```java
// Bad
public void test1() { ... }

// Good
public void additionWithPositiveNumbers_returnsCorrectSum() { ... }
```

### 3. Arrange-Act-Assert Pattern

```java
public void testDivision() {
    // Arrange - Set up test data
    Calculator calc = new Calculator();
    
    // Act - Execute the code being tested
    double result = calc.divide(10, 2);
    
    // Assert - Verify the result
    assertEquals(5.0, result, "10 / 2 should equal 5");
}
```

---

## Testing Edge Cases

Always test:
- **Normal cases** - Typical usage
- **Edge cases** - Boundary conditions
- **Error cases** - Invalid input

```java
public class StringValidatorTest {
    
    public void validateStringLength() {
        StringValidator validator = new StringValidator();
        
        // Normal case
        assertTrue(validator.isValid("Hello"), "Valid string");
        
        // Edge cases
        assertTrue(validator.isValid(""), "Empty string");
        assertTrue(validator.isValid("A"), "Single character");
        
        // Error case
        assertFalse(validator.isValid(null), "Null should be invalid");
    }
}
```

---

## Running Your Tests

### Method 1: Using Assertions (need -ea flag)

```bash
javac testing/examples/Example1.java
java -ea testing.examples.Example1
```

### Method 2: Using Custom Assertions

```bash
javac testing/examples/Example2.java
java testing.examples.Example2
```

---

## Common Testing Terms

- **Test Case** - A single scenario being tested
- **Test Suite** - A collection of test cases
- **Assert** - Verify that something is true
- **Expected Result** - What you think should happen
- **Actual Result** - What actually happens
- **Pass/Fail** - Test succeeds or throws an error

---

## Limitations of Built-in Testing

While assertions are useful, they have limitations:
- No test discovery (must run each test manually)
- No test reporting
- No test organization features
- No setup/teardown hooks

This is why professional projects use **JUnit** or **TestNG**, which you'll learn later!

---

## Learning Outcomes

After this module, you should be able to:
- ✅ Write assertions to validate your code
- ✅ Create simple custom assertion methods
- ✅ Follow the Arrange-Act-Assert pattern
- ✅ Test normal, edge, and error cases
- ✅ Understand why testing is important

---

## Practice Tips

1. **Write tests as you code** - Don't wait until the end
2. **Test small units** - Test individual methods, not entire programs
3. **Make tests independent** - Each test should work on its own
4. **Keep tests simple** - Tests should be easy to understand
5. **Run tests often** - Catch problems early

---

## Next Steps

Once comfortable with basic testing:
- Learn **JUnit 5** for professional testing
- Explore **test-driven development (TDD)**
- Study **mocking** and **integration testing**
