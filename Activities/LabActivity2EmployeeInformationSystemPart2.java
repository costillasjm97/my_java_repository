import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        String upperTextFirstName = firstName.toUpperCase();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        String upperTextLastName = lastName.toUpperCase();

        System.out.print("Enter your age: ");
        int age = input.nextInt();
        int retirementAge = 65;
        int yearsToRetirement = Math.abs(retirementAge - age);

        System.out.print("Enter hours worked: ");
        double hoursWorked = input.nextDouble();

        System.out.print ("Enter hourly wage: ");
        double hourlyWage = input.nextDouble();

        System.out.println();

        System.out.println("Employee Information"); 
        System.out.println("----------------------");
        System.out.println("Full Name: " + upperTextFirstName + " " + upperTextLastName);
        System.out.println("Age: " + age + " " + "years old");
        System.out.println("Years to Retirement: " + yearsToRetirement + " " + "years");

        double dailyWage = hoursWorked*hourlyWage;
        double roundedDailyWage = Math.round(dailyWage);
        System.out.println("Daily Salary: PHP" + " " + roundedDailyWage);

        System.out.println("Weekly Salary: PHP" + " " + roundedDailyWage*5);
        double weeklyWage = roundedDailyWage*5;

        System.out.println("Monthly Salary: PHP" + " " + weeklyWage*4);
        double monthlyWage = weeklyWage*4;

        System.out.println("Gross Yearly Salary: PHP" + " " + monthlyWage*12);

        double grossYearlyWage = monthlyWage * 12;
        double taxDeduction = 0.32 * grossYearlyWage;
        double governmentBenefits = 1500.00;
        double netYearlyWage = grossYearlyWage - taxDeduction - governmentBenefits;
        System.out.println("Net Yearly Salary: PHP" + " " + netYearlyWage);

    }
    
}
