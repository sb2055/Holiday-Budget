
import java.util.Scanner;

public class HolidayBudget {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("HELLO AND WELCOME TO THE HOLIDAY GIFT PLANNER");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your holiday budget: $");
        double budget = input.nextDouble();
        input.nextLine();

        while (budget <= 0) {
            System.out.print("Budget must be more than $0. Try again: ");
            budget = input.nextDouble();
            input.nextLine();
        }

        double total = 0;
        int recipientCount = 0;
        int giftCount = 0;
        String moreRecipients = "yes";

        while (moreRecipients.equalsIgnoreCase("yes")) {

            System.out.print("\nEnter the recipient's name: ");
            String recipient = input.nextLine();
            recipientCount++;

            double personTotal = 0;
            int personGifts = 0;
            String moreGifts = "yes";

            while (moreGifts.equalsIgnoreCase("yes")) {

                System.out.print( "Enter the gift name: ");
                String gift = input.nextLine();

                System.out.print( " Enter the gift price: $");
                double price = input.nextDouble();
                input.nextLine();

                if (price > 0) {
                    personTotal = personTotal + price;
                    total = total + price;
                    personGifts++;
                    giftCount++;

                    System.out.println(" " + gift + " added for " + recipient + "!");

                    if (total > budget) {
                        System.out.println(" Warning! You are over your budget!");
                    } else {
                        System.out.println(" You are still within your budget!");
                    }

                } else {
                    System.out.println("  Invalid price! Gift not added.");

                    }
                System.out.print("  Add another gift for " + recipient + "? (yes/no): ");
                moreGifts = input.nextLine();
            }

            System.out.printf("%s: %d gift(s), $%.2f total%n",
                    recipient, personGifts, personTotal);

            System.out.print("\nShop for another person? (yes/no): ");
            moreRecipients = input.nextLine();
        }

        double remaining = budget - total;

        System.out.println("\n================================");
        System.out.println("HOLIDAY GIFT REPORT");
        System.out.println("================================");

        System.out.println("Shopper: " + name.toUpperCase());
        System.out.println("People Shopped For: " + recipientCount);
        System.out.println("Total Gifts: " + giftCount);

        System.out.printf("Holiday Budget: $%.2f%n", budget);
        System.out.printf("Total Spending: $%.2f%n", total);
        System.out.printf("Money Remaining: $%.2f%n", remaining);

        if (remaining > 0) {
            System.out.println("Great job! You stayed within your budget!");
        } else if (remaining == 0) {
            System.out.println("Perfect! You spent exactly your budget!");
        } else {
            System.out.println("You exceeded your holiday budget!");
        }

        int rows = recipientCount;
        if (rows > 8) {
            rows = 8;
        }

        System.out.println("\nYour Holiday Tree:");
        for (int row = 1; row <= rows; row++) {

            for (int space = 1; space <= rows - row; space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= (2 * row) - 1; star++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println("\nHappy Holidays, " + name + "!");

        input.close();
    }
}









