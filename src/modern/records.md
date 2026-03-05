# Records in Modern Java

Records are a simple way to create immutable data classes in Java.
They reduce boilerplate code and make data modeling cleaner.

---

## What is a Record?

```java
public record Student(String name, int age) {}
```

With one line, Java automatically creates:

- a constructor
- accessor methods (`name()` and `age()`)
- `toString()`
- `equals()`
- `hashCode()`

---

## Why Use Records?

Use records when your class mainly stores data.

Good use cases:

- DTOs (Data Transfer Objects)
- API response models
- configuration data
- value objects

---

## Example

```java
record Book(String title, String author) {}

Book book = new Book("Clean Code", "Robert C. Martin");
System.out.println(book.title());
System.out.println(book);
```

---

## Validation in Records

You can add simple validation in a compact constructor:

```java
public record User(String username, int age) {
    public User {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
```

---

## Learning Outcomes

After this topic, students can:

- explain what records are
- create and use records
- access record components
- add basic constructor validation
