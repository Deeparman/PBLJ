import java.io.*;
import java.util.Scanner;

class Ques3 {
    private static final String FILE_NAME = "employeeRecord.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); 

            String employeeRecord = name + "," + id + "," + designation + "," + salary;
            writer.write(employeeRecord);
            writer.newLine();

            System.out.println("Employee added successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("\nEmployee Records:\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.println("Employee #" + count++);
                    System.out.println("Name       : " + parts[0]);
                    System.out.println("ID         : " + parts[1]);
                    System.out.println("Designation: " + parts[2]);
                    System.out.println("Salary     : " + parts[3]);
                    System.out.println();  
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
