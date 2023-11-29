// ApartmentsLinkedList.java
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ApartmentsLinkedList {
    public static void main(String[] args) {
        LinkedList<Apartment> apartmentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Prompt user for apartment details until a sentinel value is entered
        while (true) {
            System.out.println("Enter apartment details or type 'exit' to finish:");

            System.out.print("Street Address: ");
            String streetAddress = scanner.nextLine();

            if (streetAddress.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Apartment Number: ");
            int apartmentNumber = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            System.out.print("Monthly Rent: ");
            double monthlyRent = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character

            System.out.print("Number of Bedrooms: ");
            int numberOfBedrooms = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            Apartment apartment = new Apartment(streetAddress, apartmentNumber, monthlyRent, numberOfBedrooms);
            apartmentList.add(apartment);
        }

        // Sort the apartments by rent value
        Collections.sort(apartmentList);

        // Display the sorted list
        System.out.println("\nSorted List of Apartments by Rent:");
        for (Apartment apartment : apartmentList) {
            System.out.println(apartment);
        }
    }
}

