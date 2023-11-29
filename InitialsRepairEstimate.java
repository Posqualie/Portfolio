import java.util.Scanner;

public class InitialsRepairEstimate {
    public static final double LABOR_RATE = 43.50;
    public static final double TRAVEL_RATE = 9.25;
    public static final double DISCOUNT_RATE = 0.125;
    public static final double TAX_RATE = 0.0825;
    public static final double MAX_TRAVEL_TIME = 2.0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for job name and materials
        System.out.print("Enter job name: ");
        String jobName = input.nextLine();

        System.out.print("Enter itemized list of materials (each item, quantity, and price):\n");
        double materialCost = 0.0;
        while (true) {
            System.out.print("Enter item (or 'done' to finish): ");
            String item = input.nextLine();
            if (item.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
            input.nextLine(); // consume newline character

            System.out.print("Enter price: ");
            double price = input.nextDouble();
            input.nextLine(); // consume newline character

            materialCost += quantity * price;
        }

        // Prompt for estimated labor and travel time
        System.out.print("Enter estimated labor time (in hours): ");
        double laborTime = input.nextDouble();

        System.out.print("Enter estimated travel time (in hours): ");
        double travelTime = input.nextDouble();

        // Compute estimate
        double totalCost = compute(laborTime, travelTime, materialCost);

        // Apply discount for veterans
        System.out.print("Are you a veteran? (Y/N): ");
        String veteranAnswer = input.next();
        if (veteranAnswer.equalsIgnoreCase("Y")) {
            totalCost *= 1 - DISCOUNT_RATE;
        }

        // Display estimate
        System.out.println("\nHenderson's Repair Service");
        System.out.println("Job name: " + jobName);
        System.out.println("Itemized list of materials: $" + materialCost);
        System.out.println("Labor cost: $" + laborTime * LABOR_RATE);
        System.out.println("Travel cost: $" + (travelTime > 0.5 ? (travelTime - 0.5) * TRAVEL_RATE : 0));
        System.out.println("Total estimated price: $" + totalCost);
    }

    public static double compute(double laborTime, double travelTime, double materialCost) {
        double totalCost = materialCost + laborTime * LABOR_RATE;
        if (travelTime > 0.5) {
            double travelCost = (travelTime - 0.5) * TRAVEL_RATE;
            totalCost += travelCost;
            if (travelTime > MAX_TRAVEL_TIME) {
                System.out.println("The distance is too far. Job not accepted.");
                System.exit(0);
            }
        }
        totalCost *= 1 + TAX_RATE;
        return totalCost;
    }
}