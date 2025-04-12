package Edu_Bridge.coreJava_Project;

import java.util.Scanner;

public class User extends AirLine {

    public User(String airline, String passengerName) {
        super(airline, passengerName, "", "");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---- Welcome to Airline Management System ----");

        System.out.print("Enter Airline Name: ");
        String airline = sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        String passengerName = sc.nextLine();

        User user = new User(airline, passengerName);

        boolean citiesSelected = false;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Select Cities");
            System.out.println("2. Ticket Booking");
            System.out.println("3. Ticket Update");
            System.out.println("4. Collect Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (!citiesSelected) {
                        System.out.println(user.cities());
                        citiesSelected = true;
                    } else {
                        System.out.println(" Cities already selected. You cannot change them.");
                    }
                    break;

                case 2:
                    if (citiesSelected) {
                        user.ticketBooking();
                    } else {
                        System.out.println(" Please select cities first (Option 1).");
                    }
                    break;

                case 3:
                    if (citiesSelected) {
                        user.ticketUpdate();
                    } else {
                        System.out.println(" Please select cities first (Option 1).");
                    }
                    break;

                case 4:
                    if (citiesSelected) {
                        System.out.println(user.collectTicket());
                    } else {
                        System.out.println(" Please select cities first (Option 1).");
                    }
                    break;

                case 5:
                    System.out.println("\n Thank you for using our Service...\n  Visit Again & Happy Journey!");
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
