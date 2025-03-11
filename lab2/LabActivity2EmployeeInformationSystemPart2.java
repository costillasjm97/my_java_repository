import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
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

        System.out.print("Enter hours worked: ");
        double hoursWorked = input.nextDouble();

        System.out.print("Enter hourly wage: ");
        double hourlyWage = input.nextDouble();

        System.out.println(); // This print as a blank line on a new line

        System.out.println("Employee Information"); // This will print on a new line
        System.out.println("----------------------");
        System.out.println("Full Name:\t\t" + upperTextFirstName + " " + upperTextLastName);
        System.out.println("Age:\t\t\t" + age + " " + "years old");
        System.out.println("Years to Retirement:\t" + yearsToRetirement + " " + "years");

        double dailyWage = hoursWorked*hourlyWage;
        double roundedDailyWage = Math.round(dailyWage);
        System.out.printf("Daily Salary:\t\t\t" + "Php" + " " + "%.2f\n", roundedDailyWage); //This method directly prints the formatted number to the console

        System.out.printf("Weekly Salary:\t\t\t" + "Php" + " " + "%.2f\n", roundedDailyWage*5);
        double weeklyWage = roundedDailyWage*5;

        System.out.printf("Monthly Salary:\t\t\t" + "Php" + " " + "%.2f\n", weeklyWage*4);
        double monthlyWage = weeklyWage*4;

        System.out.printf("Gross Yearly Salary:\t\t" + "Php" + " " + "%.2f\n", monthlyWage*12);

        double grossYearlyWage = monthlyWage * 12;
        double taxDeduction = 0.32 * grossYearlyWage;
        double governmentBenefits = 1500.00;
        double netYearlyWage = grossYearlyWage - taxDeduction - governmentBenefits;
        System.out.printf("Net Yearly Salary:\t\t" + "Php" + " " + "%.2f\n", netYearlyWage);

    }  
}