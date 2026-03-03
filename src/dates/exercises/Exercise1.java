package dates.exercises;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Exercise 1: Basic Date and Time Operations
 *  Complete the following tasks
 *
 * 1. Create a LocalDate for your birthday
 * 2. Print your birthday in the format: "I was born on [day of week], [month] [day], [year]"
 * 3. Find out if your birth year was a leap year
 * 4. Create a LocalTime for when you usually wake up
 * 5. Create a LocalDateTime combining your birthday and wake-up time
 * 6. Print how many days old you are today
 * 7. Print which day of the year you were born on (1-365)
 */
public class Exercise1 {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // TODO: Task 1 - Create your birthday
        LocalDate birthday = LocalDate.of(1994, 8, 26); // Replace with your birthday



        // TODO: Task 2 - Print formatted birthday message
        System.out.printf("I was born on %s%n", birthday.format(fmt));
        // TODO: Task 3 - Check if leap year
        System.out.println("Was I born in a leap year? " + birthday.isLeapYear());
        // TODO: Task 4 - Print day of year you were born
        System.out.println("I was born on day " + birthday.getDayOfYear() + " of the year.");

        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime birthdayTime = LocalDateTime.of(birthday, LocalDateTime.now().toLocalTime());
        System.out.println("My birthday and wake-up time: " + birthdayTime.format(timeFmt));
        System.out.println("Days old today: " + ChronoUnit.DAYS.between(birthday, LocalDate.now())); // https://stackoverflow.com/questions/27005861/calculate-days-between-two-dates-in-java-8
        System.out.println("Day of the year I was born: " + birthday.getDayOfYear());
    }
}
