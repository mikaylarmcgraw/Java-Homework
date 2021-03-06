import java.util.Scanner;

public class Assignment01Driver {
    Scanner input = new Scanner(System.in);
    Scanner stringInput = new Scanner(System.in);
    public static void main(String[] args) {
        new Assignment01Driver();
    }

    // This will act as our program switchboard
    public Assignment01Driver() {
        String userInput = null;
        
        String[] cargohold = new String[10];

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

            switch (userChoice) 
            {
             case 1:
                System.out.println("You selected to add to your BlackStar Cargo Hold!");
                System.out.println("Please enter item you'd like to enter into BlackStar Cargo Hold:");
                userInput = stringInput.nextLine();
                addItem(cargohold,userInput);
                break;
             case 2:
                System.out.println("You selected to remove an item from your cargo bin!");
                System.out.println("Please enter an item you'd like to remove from your cargo bin:");
                userInput = stringInput.nextLine();
                removeItem(cargohold,userInput);
                break;
             case 3:
                System.out.println("Your Blackstar Cargo Hold employee on duty is sorting the cargo as we speak...");
                sortItems(cargohold);
                System.out.println("The employee is done sorting here is the BlackStar Cargo Hold sorted: ");
                displayItems(cargohold);
                break;
             case 4:
                System.out.println("Your Blackstar Cargo Hold on duty is ready to help you search for any items you desire!");
                System.out.println("Please enter the item you'd like to search the Blackstar Cargo Hold for: ");
                userInput = stringInput.nextLine();
                searchItems(cargohold, userInput);
                break;
             case 5:
                System.out.println("Blackstar attendant on duty is displaying items:");
                displayItems(cargohold);
                break;
             case 0:
                System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
                System.exit(0);
                
             default:
                System.out.println("Please enter menu options '1' - '5' to manipulate BlackStar Cargo Hold or '0' to exit.");
            }
        }

    }

    private void addItem(String cargohold[], String userInput) 
    {
        // TODO: Add an item that is specified by the user
        boolean flag = true;
        int counter = 0;
        
        while (flag)
        {
            if ((counter == 9) && (cargohold[counter]!= null))
            {
                System.out.println("Cargo bin is full, please remove items in order to add new items to cargo bin.");
                flag = false;
            }
            
                else if (cargohold[counter] != null)
                {
                    
                    counter++;
                    
                }
                
                    else
                    {
                        cargohold[counter] = userInput;
                        System.out.println("You successfully added " + userInput + " to your cargo bin!");
                        flag = false;
                    }
            

        }
        
        
    }

    private void removeItem(String cargohold[], String userInput) 
    {
        // TODO: Remove an item that is specified by the user 
        boolean flag = true;
        int counter = 0;
        int nullCounter = 0;
        
        //sorting through to check for empty cargo hold 
        for (int i = 0; i < cargohold.length; i++)
        {
          if (cargohold[i] == null)
          {
             nullCounter++;
          }
                    
        }
        
        //display message if empty
        if (nullCounter == cargohold.length)
        {
          System.out.println("The head cargo attendant on duty reported that the cargo hold is empty and unable to remove any item(s).");
          System.out.println("In order to enable remove function please add item(s) to cargo hold.");
          flag = false;
        }
            
            else
            {
                while (flag == true)
                {
                  if (cargohold[counter] != null)
                  {
                        
                        
                    if ((counter == 9) && (userInput.compareToIgnoreCase(cargohold[counter]) != 0))
                    {
                                
                        System.out.println("The head cargo attendant on duty could not find " + userInput + " within your current cargo to remove.");
                        flag = false;
                    }
        
                       
                       else if (userInput.compareToIgnoreCase(cargohold[counter]) == 0)
                       {
                         System.out.println("The head cargo attendant on duty found: " + userInput +" and successfully removed item from Blackstar cargo hold!");
                         cargohold[counter] = null;
                         flag = false;
                       }
                         else if ((userInput.compareToIgnoreCase(cargohold[counter]) != 0) && (counter < 9))
                         {
                           counter++;
                                    
                         }
                  }        
                  else if (counter < 9)
                  {
                      counter++;
                      
                  }
                    else
                    {
                        System.out.println("The head cargo attendant on duty could not find " + userInput + " within your current cargo to remove.");
                        flag = false;
                    }
                }
            }
    }

    private void sortItems(String cargohold[]) {
        // TODO: Sort the items in the cargo hold (No need to display them here) - Use Selection or Insertion sorts
        // NOTE: Special care is needed when dealing with strings! research the compareTo() method with strings
        for (int i = 0; i < cargohold.length - 1; i++)
        {
            int index = i;
            
            for (int j = i + 1; j < cargohold.length; j++)
            {
                if ((cargohold[i] == null) && (cargohold[j] != null)) // condition C (when i is null and j is not null)
                {
                    cargohold[i] = cargohold[j];
                    cargohold[j] = null;
                    
                    
                }
                    else if ((cargohold[i] == null) && (cargohold[j] == null)) // conditon A (when i and j are both null)
                    {
                      //no need to swap
                        
                    }
                    
                        else if (cargohold[j] == null)
                        {
                            //no swap is needed
                            
                        }
                    
                           else if (cargohold[i].compareToIgnoreCase(cargohold[j]) > 0) //condition D (when both i and j have a value not equal to null)
                            {
                                index = j;
                                String ascendingString = cargohold[index];
                                cargohold[index] = cargohold[i];
                                cargohold[i] = ascendingString;
                            }
                            
                
            }
            

        }

    }

    private void searchItems(String cargohold[], String userInput) {
        // TODO: Search for a user specified item
        boolean flag = true;
        int counter = 0;
        while (flag)
        {
            if (cargohold[counter] == null && counter < 9)
            {
                
                counter++;
            }
                else
                {
                    if ((counter == 9) && (userInput.compareToIgnoreCase(cargohold[counter]) != 0))
                    {
                                
                        System.out.println("The head cargo attendant on duty could not find your " + userInput + " item you were searching for.");
                        flag = false;
                    }
        
                       else if (userInput.compareToIgnoreCase(cargohold[counter]) == 0)
                       {
                           System.out.println("The head cargo attendant on duty found: " + userInput +" at location: " + counter + " in your cargo hold!");
                           flag = false;
                       }
                           else
                           {
                              counter++;
                                            
                           }
            
              }
        }
        System.out.println();
    }

    private void displayItems(String cargohold[]) {
        // TODO: Display only the unique items along with a count of any duplicates
        //
        // For example it should say
        // Food - 2
        // Water - 3
        // Ammunition - 5
        
        //initalizing variables
        int occurence = 0;
        int counter = 0;
        boolean flag = true;
        
        //declaring a new array called copyCargoHold and setting the length equal to the original cargohold array length
        String[] copyCargoHold = new String[cargohold.length];
        
        //creating copy because I didn't want to sort real array during display but this will show items in A-Z order.
        for (int i = 0; i < copyCargoHold.length; i++)
        {
            copyCargoHold[i] = cargohold[i];
            
        }

        //sorting copy of cargo hold to organize items before counting occurences 
        //for maintainability I would like to call the sort function up above within the switch before displaying but didn't 
        //want to pass in additional peremeters above. 
        for (int i = 0; i < copyCargoHold.length - 1; i++)
        {
            int index = i;
            
            for (int j = i + 1; j < copyCargoHold.length; j++)
            {
                if ((copyCargoHold[i] == null) && (copyCargoHold[j] != null)) // condition C (when i is null and j is not null)
                {
                    copyCargoHold[i] = copyCargoHold[j];
                    copyCargoHold[j] = null;
                    
                    
                }
                    else if ((copyCargoHold[i] == null) && (copyCargoHold[j] == null)) // conditon A (when i and j are both null)
                    {
                      //no need to swap
                        
                    }
                    
                        else if (copyCargoHold[j] == null)
                        {
                            //no swap is needed
                            
                        }
                    
                           else if (copyCargoHold[i].compareToIgnoreCase(copyCargoHold[j]) > 0) //condition D (when both i and j have a value not equal to null)
                            {
                                index = j;
                                String ascendingString = copyCargoHold[index];
                                copyCargoHold[index] = copyCargoHold[i];
                                copyCargoHold[i] = ascendingString;
                            }
                            
                
            }
            

        }

        //looping through sorted copy array and counting occurences for user display this is to ensure real cargohold isn't sorted
        for(int i = 0; i <= copyCargoHold.length - 1; i = i + occurence)
        {
            occurence = 1;
            
            for (int j = i + 1; j < copyCargoHold.length; j++)
            {
                if (copyCargoHold[i] == null || copyCargoHold[j] == null)
                {
                    j = copyCargoHold.length;
                    
                }
                    else if (copyCargoHold[i].compareToIgnoreCase(copyCargoHold[j]) == 0)
                    {
                        occurence++;
                        
                    }
                
                
                
            }
            if (copyCargoHold[i] != null)
            {
                System.out.println(copyCargoHold[i] + " - " + occurence);
            
            }   
        }
        System.out.println();
    }
}
