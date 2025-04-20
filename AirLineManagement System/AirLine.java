package Edu_Bridge.AirLineManagementSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AirLine implements AirLineManagement {

    static int ticketPrice = 15000;

    String airline = "";
    String passengerName = "";
    String city = "";
    String destination = "";
    String travelDate = "";
    String flightTime = "";
    String seat = "";

    boolean ticketBooked = false;
    String transactionID = "";

    ArrayList<String> bookings = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    String[] allCities = {
            "Hyderabad", "Bangalore", "Delhi", "Mumbai",
            "Chennai", "Kolkata", "Ahmedabad", "Pune"
    };

    String[] airlineOptions = {
            "Indigo", "Vistara", "AirIndia", "SpiceJet",
            "GoFirst", "AkasaAir"
    };

    String[] flightTimes = {
            "06:00 AM", "09:45 AM", "12:30 PM",
            "03:15 PM", "06:00 PM", "09:00 PM"
    };

    public AirLine() {}

    @Override
    public int ticketBooking() {
        System.out.println("\n Available Cities:");
        for (String c : allCities) {
            System.out.println("- " + c);
        }

        System.out.print("\nEnter Starting City: ");
        city = sc.nextLine();

        System.out.print("Enter Destination City: ");
        destination = sc.nextLine();

        if (city.equalsIgnoreCase(destination)) {
            System.out.println(" Source and Destination cannot be the same.");
            return 0;
        }

        System.out.println("\n Available Airlines:");
        for (String a : airlineOptions) {
            System.out.println("- " + a);
        }

        System.out.print("Select Airline: ");
        airline = sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        passengerName = sc.nextLine();

        System.out.print("Enter Travel Date (dd-mm-yyyy): ");
        travelDate = sc.nextLine();

        flightTime = getRandomTime();


        System.out.print("\nChoose your seat (e.g., 12A, 14C): ");
        seat = sc.nextLine();


        transactionID = generateTransactionID();


        ticketBooked = true;

        System.out.println("\n✅ Ticket Booked Successfully!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Route: " + city + " → " + destination);
        System.out.println("Airline: " + airline);
        System.out.println("Date: " + travelDate + " at " + flightTime);
        System.out.println("Seat: " + seat);
        System.out.println("Fare: ₹" + ticketPrice);
        System.out.println("Transaction ID: " + transactionID);


        bookings.add(passengerName + " | " + airline + " | " + city + " → " + destination + " | " + travelDate);

        return ticketPrice;
    }

    @Override
    public int ticketUpdate() {
        if (!ticketBooked) {
            System.out.println(" Please book a ticket before updating.");
            return 0;
        }

        System.out.print("Enter new destination for " + passengerName + ": ");
        destination = sc.nextLine();

        System.out.println(" Destination updated to " + destination);
        return 1;
    }

    @Override
    public String collectTicket() {
        if (!ticketBooked) {
            return " No ticket has been booked yet. Please book a ticket first.";
        }


        String ticketDetails = "\n --- Ticket Details ---" +
                "\nPassenger: " + passengerName +
                "\nAirline: " + airline +
                "\nFrom: " + city +
                "\nTo: " + destination +
                "\nDate: " + travelDate +
                "\nTime: " + flightTime +
                "\nSeat: " + seat +
                "\nFare: ₹" + ticketPrice +
                "\nTransaction ID: " + transactionID;


        saveTicketToFile(ticketDetails);

        return ticketDetails;
    }

    public void cancelBooking() {
        if (!ticketBooked) {
            System.out.println("⚠️ No booking to cancel.");
            return;
        }

        System.out.print("Enter reason for cancellation: ");
        String reason = sc.nextLine();

        System.out.println("\n Cancellation Reason Recorded: " + reason);


        airline = "";
        passengerName = "";
        city = "";
        destination = "";
        travelDate = "";
        flightTime = "";
        seat = "";
        transactionID = "";
        ticketBooked = false;

        System.out.println(" Booking has been successfully canceled.");
    }


    private String generateTransactionID() {
        return "TX" + new Random().nextInt(1000000);
    }


    private void saveTicketToFile(String ticketDetails) {
        try {
            FileWriter fileWriter = new FileWriter(passengerName + "_Ticket.txt");
            fileWriter.write(ticketDetails);
            fileWriter.close();
            System.out.println(" Ticket details saved to " + passengerName + "_Ticket.txt");
        } catch (IOException e) {
            System.out.println(" Error while saving ticket.");
        }
    }

    private String getRandomTime() {
        Random rand = new Random();
        return flightTimes[rand.nextInt(flightTimes.length)];
    }
}
