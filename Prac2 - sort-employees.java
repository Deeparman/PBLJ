import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new Employee("John", 28, 55000));
        employees.add(new Employee("Alice", 24, 62000));
        employees.add(new Employee("Bob", 30, 50000));
        employees.add(new Employee("Diana", 28, 70000));

        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("Sorted by name:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by age:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nSorted by salary (descending):");
        employees.forEach(System.out::println);
    }
}
