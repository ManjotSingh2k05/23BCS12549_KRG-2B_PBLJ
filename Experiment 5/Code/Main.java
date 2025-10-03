import java.io.*;
import java.util.*;

class Staff {
    private String fullName;
    private String empId;
    private String role;
    private double pay;

    public Staff(String fullName, String empId, String role, double pay) {
        this.fullName = fullName;
        this.empId = empId;
        this.role = role;
        this.pay = pay;
    }

    public String toFileFormat() {
        return fullName + "|" + empId + "|" + role + "|" + pay;
    }

    public static Staff fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        return new Staff(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    @Override
    public String toString() {
        return fullName + " | " + empId + " | " + role + " | " + pay;
    }
}

public class Main {

    private static final String FILE_PATH = "staff_records.txt";
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Menu ===");
            System.out.println("1. Register Staff");
            System.out.println("2. View All Staff");
            System.out.println("3. Exit");
            System.out.print("\nEnter option: ");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1 -> registerStaff();
                case 2 -> viewAllStaff();
                case 3 -> {
                    System.out.println("Closing program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option, please retry.");
            }
        }
    }

    private static void registerStaff() {
        System.out.print("Full Name: ");
        String fullName = input.nextLine();
        System.out.print("Employee ID: ");
        String empId = input.nextLine();
        System.out.print("Role: ");
        String role = input.nextLine();
        System.out.print("Salary: ");
        double pay = input.nextDouble();
        input.nextLine();

        Staff s = new Staff(fullName, empId, role, pay);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(s.toFileFormat());
            writer.newLine();
            System.out.println("Staff record saved!");
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    private static void viewAllStaff() {
        System.out.println("\n--- Staff Records ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                Staff s = Staff.fromFileFormat(line);
                System.out.println(s);
                found = true;
            }
            if (!found) System.out.println("No records available.");
        } catch (FileNotFoundException e) {
            System.out.println("No staff records file found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
