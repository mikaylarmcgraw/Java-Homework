import java.util.Scanner;
import java.util.ArrayList;

public class Assignment02Driver {
    
    Scanner input = new Scanner(System.in);
    Scanner stringInput = new Scanner(System.in);
    public static void main(String[] args) {
        new Assignment02Driver();
    }

    // This will act as our program switchboard
    public Assignment02Driver() {
        ArrayList<Item> cargohold = new ArrayList<Item>();

        System.out.println("Welcome to the BlackStar Cargo Hold interface.");
        System.out.println("Please select a number from the options below");
        System.out.println("");

        while (true) {
            // Give the user a list of their options
            System.out.println("1: Add an item to the cargo hold.");
            System.out.println("2: Remove an item from the cargo hold.");
            System.out.println("3: Sort the contents of the cargo hold.");
            System.out.println("4: Search for an item.");
            System.out.println("5: Display the items in the cargo hold.");
            System.out.println("0: Exit the BlackStar Cargo Hold interface.");

            // Get the user input
            int userChoice = input.nextInt();
            input.nextLine();
            String userInput = null;
            switch (userChoice) {
            case 1:
                System.out.println("You chose to add an item to cargo hold!");
                System.out.println("What item would you like to add to cargo hold:");
                userInput = stringInput.nextLine();
                addItem(cargohold);
                break;
            case 2:
                removeItem(cargohold);
                break;
            case 3:
                sortItems(cargohold);
                break;
            case 4:
                searchItems(cargohold);
                break;
            case 5:
                displayItems(cargohold);
                break;
            case 0:
                System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
                System.exit(0);
            }
        }

    }

    private void addItem(ArrayList<Item> cargohold) {
        // TODO: Add an item that is specified by the user

    }

    private void removeItem(ArrayList<Item> cargohold) {
        // TODO: Remove an item that is specified by the user

    }

    private void sortItems(ArrayList<Item> cargohold) {
        // TODO: Sort the items in the cargo hold (No need to display them here) - Use Selection or Insertion sorts
        // NOTE: Special care is needed when dealing with strings! research the compareTo() method with strings

    }

    private void searchItems(ArrayList<Item> cargohold) {
        // TODO: Search for a user specified item

    }

    private void displayItems(ArrayList<Item> cargohold) {
        // TODO: Display only the unique items along with a count of any duplicates
        //
        // For example it should say
        // Food - 2
        // Water - 3
        // Ammunition - 5

    }
}