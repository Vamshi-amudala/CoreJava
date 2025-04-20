package Edu_Bridge.AirLineManagementSystem;

import java.util.Scanner;

public class User extends AirLine {

    public User() {
        super();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("---- Welcome to Airline Management System ----");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ticket Booking");
            System.out.println("2. Ticket Update");
            System.out.println("3. Collect Ticket");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View All Bookings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    user.ticketBooking();
                    break;

                case 2:
                    user.ticketUpdate();
                    break;

                case 3:
                    System.out.println(user.collectTicket());
                    break;

                case 4:
                    user.cancelBooking();
                    break;

                case 5:
                    System.out.println("\n--- All Bookings ---");
                    for (String booking : user.bookings) {
                        System.out.println(booking);
                    }
                    break;

                case 6:
                    System.out.println("\n Thank you for choosing our Service...");
                    System.out.println("✨ Visit Again & Happy Journey!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
