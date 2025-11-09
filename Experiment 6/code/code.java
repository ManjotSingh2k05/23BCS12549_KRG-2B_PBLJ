import java.util.*; 
import java.util.stream.*;

class Student { 
    String name; 
    int id; 
    double marks;

    Student(String name, int id, double marks) { 
        this.name = name; 
        this.id = id; 
        this.marks = marks; 
    }

    public String toString() { 
        return name + " - " + marks; 
    }
}

public class Main { 
    public static void main(String[] args) { 
        List<Student> students = Arrays.asList( 
            new Student("Manjot", 101, 85.5), 
            new Student("Raja", 102, 92.0), 
            new Student("Ram", 103, 78.0), 
            new Student("Harjot", 104, 68.0), 
            new Student("Ravi", 105, 72.5) 
        );

        System.out.println("Students scoring above 75%:"); 
        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75)
            .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
            .map(s -> s.name)
            .collect(Collectors.toList());

        topStudents.forEach(System.out::println); 
    } 
}
