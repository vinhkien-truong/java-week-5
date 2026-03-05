package introduction.exercises.BonusE;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
    @Override
     public int compareTo(Student other)
     {
          return  Integer.compare(other.grade, this.grade); // https://www.geeksforgeeks.org/java/double-compare-method-in-java-with-examples/
     }

     public static void sortByGrade(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                Student current = students.get(j);
                Student next = students.get(j + 1);
                if (current.getGrade() < next.getGrade()) {

                    Student temp = current;
                    students.set(j, next);
                    students.set(j + 1, temp);
                }
            }
        }
     }

    @Override
    public String toString() {
        return name + " (" + grade + ")";
    }
}
