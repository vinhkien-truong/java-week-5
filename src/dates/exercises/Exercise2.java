package dates.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Exercise 2: Date Arithmetic
 * 
 * Scenario: You are planning a project timeline
 *  Complete the following tasks
 * 
 * 1. Create a LocalDate for today (project start date)
 * 2. Calculate and print the date 7 days from today (Sprint 1 deadline)
 * 3. Calculate and print the date 2 weeks from today (Sprint 2 deadline)
 * 4. Calculate and print the date 1 month from today (Mid-project review)
 * 5. Calculate and print the date 3 months from today (Project end)
 * 6. Calculate a date that is 15 days before today (Pre-planning phase)
 * 7. Create a date 2 months and 10 days from today using chaining
 * 8. BONUS: Calculate the date of the last day of next month
 */
public class Exercise2 {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // TODO: Task 1 - Create today's date
        LocalDate today = LocalDate.now();
        
        
        // TODO: Task 2 - Sprint 1 deadline (7 days)
        System.out.println("Sprint 1 deadline: " + today.plusDays(7).format(fmt));
        
        
        // TODO: Task 3 - Sprint 2 deadline (2 weeks)
        System.out.println("Sprint 2 deadline: " + today.plusWeeks(2).format(fmt));
        
        // TODO: Task 4 - Mid-project review (1 month)
        System.out.println("Mid-project review: " + today.plusMonths(1).format(fmt));
        
        
        // TODO: Task 5 - Project end (3 months)
        System.out.println("Project end: " + today.plusMonths(3).format(fmt));
        
        
        // TODO: Task 6 - Pre-planning phase (15 days before today)
        System.out.println("Pre-planning phase: " + today.minusDays(15).format(fmt));
        
        
        // TODO: Task 7 - 2 months and 10 days from today
        System.out.println("2 months and 10 days from today: " + today.plusMonths(2).plusDays(10).format(fmt));
        
        
        // TODO: BONUS - Last day of next month (Hint: use TemporalAdjusters)
       /*  LocalDate nextMonth = today.plusMonths(1);
        LocalDate lastDayOfNextMonth = nextMonth.withDayOfMonth(nextMonth.lengthOfMonth());
        System.out.println("Last day of next month: " + lastDayOfNextMonth.format(fmt));

        */

        LocalDate lastDayOfNextMonth = today.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Last day of next month: " + lastDayOfNextMonth.format(fmt));
    }
}
