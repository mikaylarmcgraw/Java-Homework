// This item class should be in its own file.

public class Item {
    // Declare attributes here
    private int itemId = 0;
    private int itemWeight = 0;
    private String itemDurability = null;
    private String itemName = null;
    private float itemValue = 0;
    
    // Create an overridden constructor here
    public Item()
    {
        itemId++;
        
    }
    
    
    
    
    // Create accessors and mutators for your traits
    public String getName()
    {
        return itemName;    
        
    }
    
    public String getDurability()
    {
        return itemDurability;
        
    }
    
    public int getID()
    {
        
     return itemId;   
    }
    
    public int getWeight()
    {
        return itemWeight;
    }
    
    public float getValue()
    {
        
        return itemValue;
    }
    
    public void setName(String userInputName)
    {
        itemName = userInputName;
        
    }
    
    
    public void setId()
    {
        
    }
    
    public void setWeight(int userInputWeight)
    {
        itemWeight = userInputWeight;
        
    }
    
    public void setDurability(String userDurability)
    {
        if (userDurability == null)
        {
            userDurability = "medium";
        }   
            else if (userDurability.compareToIgnoreCase("low") == 0 || 
                userDurability.compareToIgnoreCase("medium") == 0 ||
                userDurability.compareToIgnoreCase("high") == 0)
                {
                    //do nothing
                }
                
                    else
                    {
                        userDurability = "medium";
                    }
        
        itemDurability = userDurability;
        
    }
    
    public void setValue(float userInputValue)
    {
        itemValue = userInputValue;
        
    }
    
<<<<<<< HEAD
}
=======
}
>>>>>>> 418b99219361e853abdea22ad6d03baeaa0abacb
