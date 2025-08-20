import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a number:");
            double num = sc.nextDouble();
            if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number");
            }
            double result = Math.sqrt(num);
            System.out.println("Square root: " + result);
        } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
        }
    }
}