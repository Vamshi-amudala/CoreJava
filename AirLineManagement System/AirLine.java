package Edu_Bridge.coreJava_Project;

import java.util.Scanner;

public class AirLine implements AirLineManagement {

    static int ticketPrice = 15000;

    String airline;
    String passengerName;
    String city;
    String destination;

    Scanner sc = new Scanner(System.in);

    public AirLine(String airline, String passengerName, String city, String destination) {
        this.airline = airline;
        this.passengerName = passengerName;
        this.city = city;
        this.destination = destination;
    }

    @Override
    public int ticketBooking() {
        System.out.println("Booking ticket...");
        System.out.println("Passenger: " + passengerName);
        System.out.println("From: " + city + " → To: " + destination);
        System.out.println("Airline: " + airline);
        System.out.println("Total Fare: " + ticketPrice);
        return ticketPrice;
    }

    @Override
    public int ticketUpdate() {
        System.out.println("Enter new destination for " + passengerName + ":");
        destination = sc.next();
        System.out.println("Destination updated to " + destination);
        return 1;
    }

    @Override
    public String collectTicket() {
        return "Passenger: " + passengerName + "," +
                "\nAirline: " + airline +"," +
                "\nRoute: " + city + " --> " + destination +"," +
                "\nFare: ₹" + ticketPrice;
    }

    @Override
    public String cities() {
        String[] cityNames = {"Hyderabad", "Bangalore", "Delhi", "Mumbai", "Chennai"};

        System.out.println("Available Cities:");
        for (String c : cityNames) {
            System.out.println("- " + c);
        }

        System.out.println("Enter a Starting city: ");
        city = sc.next();

        System.out.println("Enter a Destination city: ");
        destination = sc.next();

        return  "Starting city:" + city + " to " + destination + " Destination";
    }
}
