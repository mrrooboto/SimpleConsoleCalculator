package SimpleCalculator.com;

import java.util.Scanner;

public class SimpleCalculator  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Simple Calculator App!");
        String proceed;
        int choice;
        do {
            do {
                System.out.println("Please select an operation: ");
                System.out.println("""
                        1. Addition (+)
                        2. Subtraction (-)
                        3. Multiplication (*)
                        4. Division (/)""");
                System.out.println("Enter your choice: ");
                while (!sc.hasNextInt()) { // Loop to make sure there is a number entered, not a String
                    System.out.println("Please enter a number.");
                    sc.next(); // Token passing so the choice is required as a next token
                }
                choice = sc.nextInt();
                sc.nextLine(); // Also token passing because of nextInt() method
                if (choice < 0 || choice > 4) { // Condition to make sure the number entered is in range of 1 - 4
                    System.out.println("Invalid input.. please enter a number between 1 - 4.");
                }
            } while (choice < 0 || choice > 4);

            System.out.println("Enter the first number: ");
            int num1 = sc.nextInt();
            System.out.println("Enter the second number: ");
            int num2 = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.printf("Result: %d + %d = %d%n", num1, num2, num1 + num2);
                case 2 -> System.out.printf("Result: %d - %d = %d%n", num1, num2, num1 - num2);
                case 3 -> System.out.printf("Result: %d * %d = %d%n", num1, num2, num1 * num2);
                case 4 -> {
                    if (num2 == 0 || num1 == 0) { // Condition to make sure to prevent dividing by zero
                        System.out.println("You cannot divide by 0.");
                    } else
                        System.out.printf("Result: %d / %d = %d%n", num1, num2, num1 / num2);
                }
            }
            System.out.println("Do you want to perform another calculation ? (yes/no): ");
            sc.next();
            proceed = sc.nextLine();
        } while (!proceed.equals("no")); // do the loop until the proceed option is "no"
        sc.close(); // Closing scanner leak
    }
}
                    // FINISHED CALCULATOR APP