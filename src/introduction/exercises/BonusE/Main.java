package introduction.exercises.BonusE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
You are building a small student ranking system for a school.
The school wants to display students sorted by their grades, from highest to lowest.
Your task is to design a system that makes this possible.

Step 1 — Create the Student class
Create a class called Student.
Each student has:
name
gradeRequirements:
fields must be private
provide a constructor
provide getters

override toString() so students can be printed nicely
Example:
Alice (90)
Bob (75)
Charlie (82)

Step 2 — Create some students
In main():
create a List<Student>

add at least 5 students
Example:

List<Student> students = new ArrayList<>();

students.add(new Student("Alice", 90));
students.add(new Student("Bob", 75));
students.add(new Student("Charlie", 82));
students.add(new Student("Emma", 65));
students.add(new Student("David", 80));

Step 3 — Sort the students
The school wants to print students from highest grade to lowest grade.
Your task:
Sort the students by grade

Think about the following questions:
How can Java know which student is greater or smaller?

How can two Student objects be compared?
Where should that comparison logic live?
After sorting, print the list.
Expected output:
Students ranked by grade:

Alice (90)
Charlie (82)
David (80)
Bob (75)
Emma (65)
*/
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 90));
        students.add(new Student("Bob", 75));
        students.add(new Student("Charlie", 82));
        students.add(new Student("Emma", 65));
        students.add(new Student("David", 80));
 
       /* 
        Collections.sort(students);

        System.out.println("Students ranked by grade:");
        for (Student student : students) {
            System.out.println(student);
        }*/
       Student.sortByGrade(students);
        System.out.println("Students ranked by grade:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
}
