import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        String upperTextFirstName = firstName.toUpperCase(); // This will print the string input in an upperCase style as output

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        String upperTextLastName = lastName.toUpperCase(); 

        System.out.print("Enter your age: ");
        int age = input.nextInt();
        int retirementAge = 65; 
        int yearsToRetirement = Math.abs(retirementAge - age);
        
        if (age < 18) {     // Check if the age is below 18
            System.out.println("Minors are not allowed");
            System.exit(0);
        } else if (age >= 65) {     // Check if the age is greater than or equal to 65
            System.out.println("Senior Citizens are not allowed");
            System.exit(0);
        } else {

        }

        System.out.print("Enter hours worked: ");
        double hoursWorked = input.nextDouble(); 

        if (hoursWorked > 24) {     // Check if the daily work hours are greater than 24
            System.out.println("Number of hours worked cannot exceed 24 hours");
            System.exit(0);
        } else if (hoursWorked <= 0) {     // Check if the daily work hours are zero or any other invalid value
            System.out.println("Wrong input on daily work hours");
            System.exit(0);
        } else {
            
        }

        System.out.print("Enter hourly wage: ");
        double hourlyWage = input.nextDouble();

        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int roleCode = input.nextInt();
        String role = "";

        switch (roleCode) {
            case 1:
                role = "Manager";
                break;
            case 2:
                role = "Supervisor";
                break;
            case 3:
                role = "Staff";
                break;
            case 4:
                role = "Intern";
                break;
            default:
                role = "Undefined";
        }

        System.out.println(); // This print as a blank line on a new line

        System.out.println("Employee Information"); // This will print on a new line
        System.out.println("----------------------");
        System.out.println("Full Name:\t\t" + upperTextFirstName + " " + upperTextLastName);
        System.out.println("Age:\t\t\t" + age + " " + "years old");
        System.out.println("Position:\t\t" + role);
        System.out.println("Years to Retirement:\t" + yearsToRetirement + " " + "years");

        double dailyWage = hoursWorked*hourlyWage;
        double roundedDailyWage = Math.round(dailyWage);
        System.out.printf("Daily Salary:\t\t" + "Php" + " " + "%.2f\n", roundedDailyWage); //This method directly prints the formatted number to the console

        System.out.printf("Weekly Salary:\t\t" + "Php" + " " + "%.2f\n", roundedDailyWage*5);
        double weeklyWage = roundedDailyWage*5;

        System.out.printf("Monthly Salary:\t\t" + "Php" + " " + "%.2f\n", weeklyWage*4);
        double monthlyWage = weeklyWage*4;

        System.out.printf("Gross Yearly Salary:\t" + "Php" + " " + "%.2f\n", monthlyWage*12);
        double grossYearlyWage = monthlyWage * 12;

        double taxDeduction = 0.32 * grossYearlyWage;
        double governmentBenefits = 1500.00;
        double netYearlyWage = grossYearlyWage - taxDeduction - governmentBenefits;

        if (grossYearlyWage > 250000) {
            System.out.printf("Net Yearly Salary:\t" + "Php" + " " + "%.2f\n", netYearlyWage);
        } else if (grossYearlyWage <= 250000) {
            System.out.printf("Net Yearly Salary:\t" + "Php" + " " + "%.2f\n", grossYearlyWage - governmentBenefits);
        }
    }  
}