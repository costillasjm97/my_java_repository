import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print ("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter hours worked: ");
        float hoursWorked = input.nextFloat();

        System.out.print ("Enter hourly wage: ");
        float hourlyWage = input.nextFloat();
        
        System.out.println(); // This print as a blank line

        System.out.println("Employee Information"); // This will print on a new line
        System.out.println("----------------------");
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age + " " + "years old");
        System.out.println("Daily Salary: " + "PHP" + hoursWorked*hourlyWage);
        

    }
}