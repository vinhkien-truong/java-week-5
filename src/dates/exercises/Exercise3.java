package dates.exercises;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Exercise 3: Period and Duration Calculations
 * 
 * Scenario: You need to calculate time differences for various situations
 *  Complete the following tasks
 * 
 * 1. Calculate your exact age in years, months, and days using Period
 * 2. Create a method that calculates the number of days between two dates
 * 3. Calculate the working hours in a day (9:00 AM to 5:30 PM) using Duration
 * 4. Add a 30-minute lunch break to calculate actual working time
 * 5. Calculate how many days are left until New Year's Day (January 1, 2027)
 * 6. Create a Period of 1 year, 6 months, and 15 days, then add it to today
 * 7. BONUS: Calculate how many full weeks are between your birthday and today
 */
public class Exercise3 {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // TODO: Task 1 - Calculate your age
        LocalDate birthday = LocalDate.of(1994, 8, 26); // Replace with your birthday
        LocalDate today = LocalDate.now();
        
        
        // TODO: Task 2 - Create a method to calculate days between dates
        // Call it with two different dates and print the result
        long daysBetween = calculateDaysBetween(birthday, today);
        System.out.println("Days between birthday and today: " + daysBetween);

        // TODO: Task 3 - Calculate working hours
        LocalTime workStart = LocalTime.of(9, 0);
        LocalTime workEnd = LocalTime.of(17, 30);
        Duration workingHours = Duration.between(workStart, workEnd);
        System.out.printf("Working hours in a day: %d hours and %d minutes%n", workingHours.toHours(), workingHours.toMinutesPart());


        // TODO: Task 4 - Calculate actual working time (subtract 30 min lunch)
        Duration lunchBreak = Duration.ofMinutes(30);
        Duration actualWorkingHours = workingHours.minus(lunchBreak);
        System.out.printf("Actual working hours after lunch break: %d hours and %d minutes%n", actualWorkingHours.toHours(), actualWorkingHours.toMinutesPart());


        // TODO: Task 5 - Days until New Year 2027
        LocalDate newYear2027 = LocalDate.of(2027, 1, 1);
        long daysUntilNewYear = ChronoUnit.DAYS.between(today, newYear2027);
        System.out.println("Days until New Year 2027: " + daysUntilNewYear);
        
        // TODO: Task 6 - Add period to today
        Period periodToAdd = Period.of(1, 6, 15);
        LocalDate futureDate = today.plus(periodToAdd);
        System.out.println("Date after adding period: " + futureDate);
        
        // TODO: BONUS - Calculate full weeks between birthday and today
        long fullWeeks = ChronoUnit.WEEKS.between(birthday, today);
        System.out.println("Full weeks between birthday and today: " + fullWeeks);
        
    }
    
    // TODO: Task 2 - Implement this method
    public static long calculateDaysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }
}
