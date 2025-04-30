import java.util.Scanner;

class Ticket {
    String description;
    String urgency;
    String status;

    Ticket(String description, String urgency) {
        this.description = description;
        this.urgency = urgency;
        this.status = "Pending"; // Default status
    }
}

public class MyMidtermLabExam {
    static final int MAX_TICKETS = 5;
    static Ticket[] tickets = new Ticket[MAX_TICKETS];
    static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTicket(input);
                    break;
                case 2:
                    updateTicketStatus(input);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (choice != 5);

        input.close();
    }

    static void displayMenu() {
        System.out.println("\n=== IT Ticket System ===");
        System.out.println("1. Add Ticket");
        System.out.println("2. Update Ticket Status");
        System.out.println("3. Show All Tickets");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    static void addTicket(Scanner input) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Maximum number of tickets reached.");
            return;
        }

        System.out.print("Enter issue description: ");
        String description = input.nextLine();
        System.out.print("Enter urgency level (Low / Medium / High): ");
        String urgency = input.nextLine();

        tickets[ticketCount] = new Ticket(description, urgency);
        ticketCount++;
        System.out.println("Ticket successfully added!");
    }

    static void updateTicketStatus(Scanner input) {
        // Show all tickets before updating
        showTickets();
        System.out.print("Enter ticket number to update: ");
        int ticketNumber = input.nextInt();
        input.nextLine(); // Consume newline

        if (ticketNumber < 1 || ticketNumber > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        Ticket ticket = tickets[ticketNumber - 1];
        if (ticket.status.equals("Resolved")) {
            System.out.println("Cannot update a resolved ticket.");
            return;
        }

        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = input.nextLine();

        if (newStatus.equals("In Progress") || newStatus.equals("Resolved")) {
            ticket.status = newStatus;
            System.out.println("Ticket status updated.");
        } else {
            System.out.println("Invalid status. Please enter 'In Progress' or 'Resolved'.");
        }
    }

    static void showTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("\n--- All Tickets ---");
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = tickets[i];
            System.out.println((i + 1) + "." + " " + "[" + ticket.urgency + "]" + " " + ticket.description + " " + "-" + " " + "Status: " + ticket.status);
        }
    }

    static void generateReport() {
        int pendingCount = 0;
        int resolvedCount = 0;

        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].status.equals("Resolved")) {
                resolvedCount++;
            } else {
                pendingCount++;
            }
        }

        System.out.println("\n--- Ticket Report ---");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending Tickets: " + pendingCount);
        System.out.println("Resolved Tickets: " + resolvedCount);
    }
}