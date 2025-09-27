import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class Ques2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 82.5));
        students.add(new Student("Bob", 70.0));
        students.add(new Student("Charlie", 90.0));
        students.add(new Student("Diana", 74.9));
        students.add(new Student("Ethan", 78.0));

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s1.getMarks(), s2.getMarks()))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
