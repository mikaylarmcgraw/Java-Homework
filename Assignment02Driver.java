import java.util.Scanner;
import java.util.ArrayList;

public class Assignment02Driver {
    Item myNewItem = null;
    Scanner input = new Scanner(System.in);
    Scanner stringInput = new Scanner(System.in);
    int cargoHoldCurrentWeight = 0;
    int maxWeight = 25;
    String userInputString = null;
    int userInputInt = 0;
    public static void main(String[] args) {
        new Assignment02Driver();
    }

    // This will act as our program switchboard
    public Assignment02Driver() {
        ArrayList<Item> cargohold = new ArrayList<Item>();

        System.out.println("Welcome to the BlackStar Cargo Hold interface.");
        System.out.println("Please select a number from the options below");
        System.out.println("");

        while (true) 
        {
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
            
            switch (userChoice) 
            {
                case 1:
                    System.out.println("You chose to add an item to cargo hold!");
                    addItem(cargohold);
                    break;
                case 2:
                    removeItem(cargohold);
                    break;
                case 3:
                    sortItems(cargohold);
                    break;
                case 4:
                    System.out.println("Your head cargo hold employee on deck is ready  to help you search for whatever item you desire!");
                    System.out.println("Please enter item's name you'd like to search for:");
                    userInputString = stringInput.nextLine();
                    System.out.println("Please enter item's value you'd like to search for: ");
                    userInputInt = input.nextInt(); 
                    searchItems(cargohold, userInputString, userInputInt);
                    break;
                case 5:
                    System.out.println("Your cargo hold employee on duty is getting ready to display items..");
                    System.out.println("Here are your items: ");
                    System.out.println();
                    displayItems(cargohold);
                    break;
                case 0:
                    System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
                    System.exit(0);
                    
                default:
                    System.out.println("Menu option not valid!");
                    System.out.println("Please enter either 1 - 5 to manipulate your cargo hold or press 0 to exit.");
            }
        }

    }

    private void addItem(ArrayList<Item> cargohold) 
    {
        // TODO: Add an item that is specified by the user
        //initalizing variables
        String userInputName = null;
        String userDurability = null;
        int userInputWeight = 0;
        float userInputValue = 0;
        
        //asking userInput to enter details of item and setting them
        System.out.println("What item would you like to add to cargo hold:");
        userInputName = stringInput.nextLine();
        Item myNewItem = new Item();
        myNewItem.setName(userInputName);
        System.out.println();
        
        //user enters durability
        System.out.println("Please enter item durability: ");
        userDurability = stringInput.nextLine();
        myNewItem.setDurability(userDurability);
        System.out.println();
        
        //user enters weight information
        System.out.println("Please enter weight for your item in tons: ");
        userInputWeight = input.nextInt();
        myNewItem.setWeight(userInputWeight);
        
        //user enters value of item
        System.out.println("What is the value (dollar amount) of your item:");
        userInputValue = input.nextInt();
        myNewItem.setValue(userInputValue);
        
        cargoHoldCurrentWeight = (cargoHoldCurrentWeight + myNewItem.getWeight());
        
        //checking if weight is over the maximum allowed
        if (cargoHoldCurrentWeight <= maxWeight)
        {
            
           //adding new item to array list
           cargohold.add(myNewItem);
           System.out.println();
        
        
           //displaying to user item they added and updated detailed cargo hold list
           System.out.println("You added a new item into your cargo hold called: " +myNewItem.getName());
           System.out.println();
           System.out.println("Here is a detailed overview of your item:");
           System.out.println("Item's name: "+ myNewItem.getName());
           //System.out.println("Item's ID: " + myNewItem.getId());
           System.out.println("Item's durability: " + myNewItem.getDurability());
           System.out.println("Item's weight: " + myNewItem.getWeight() + " ton(s).");
           System.out.println("Item's value: $" + myNewItem.getValue());
            
        }
            else
            {
                cargoHoldCurrentWeight = (cargoHoldCurrentWeight - myNewItem.getWeight());
                System.out.println("Cargo hold will exceed " + maxWeight + " tons if " + myNewItem.getName() + " is added.");
                System.out.println("Unable to add " + myNewItem.getName() + " at this time.");
                
            }

       
    }

    private void removeItem(ArrayList<Item> cargohold) {
        // TODO: Remove an item that is specified by the user

    }

    private void sortItems(ArrayList<Item> cargohold) {
        // TODO: Sort the items in the cargo hold (No need to display them here) - Use Selection or Insertion sorts
        // NOTE: Special care is needed when dealing with strings! research the compareTo() method with strings

    }

    private void searchItems(ArrayList<Item> cargohold, String userInput, int intInput) 
    {
        // TODO: Search for a user specified item
        int occurrence = 0;
        ArrayList<Integer> position = new ArrayList<Integer>(); 
           
        for (int i = 0; i <cargohold.size(); i++)
        {
           if (userInput.compareToIgnoreCase(cargohold.get(i).getName()) == 0)
           {
               
               if (intInput == cargohold.get(i).getValue())
               {
                   position.add(i);
                   occurrence++;
                   
                }
               

           }

        }
            
        if (occurrence == 0)
        {
           System.out.println("I'm sorry the item you were searching: " + userInput + " was not found in your cargo hold.");
                
        }
                else
                {
                    System.out.println("The item you were searching for: " + userInput + " occurred " + occurrence +" time(s) during the employee's search of cargo hold."); 
                    System.out.println("The item was found at position(s): ");
                    for (int i = 0; i < position.size(); i++)
                    {
                        System.out.print((position.get(i) + 1) + "  ");
                        
                    }
                    System.out.println();
                }
            
        
        
    }

    private void displayItems(ArrayList<Item> cargohold) 
    {
        // TODO: Display only the unique items along with a count of any duplicates
        //
        // For example it should say
        // Food - 2
        // Water - 3
        // Ammunition - 5
        for (int i = 0; i < cargohold.size(); i++)
        {
            System.out.println("Cargo hold spot: " + (i + 1)); //making positions user friendly from 1-infinite as long as within weight limit.
            System.out.println("Item's name is: " + cargohold.get(i).getName());
            //System.out.println("Item's ID is: " + cargohold.get(i).getID()); 
            System.out.println("Item's durability: " + cargohold.get(i).getDurability());
            System.out.println("Item's weight: " + cargohold.get(i).getWeight() + " ton(s).");
            System.out.println("Item's value: $" + cargohold.get(i).getValue());
            System.out.println();
        }
        
    }
}