// This item class should be in its own file.

public class Item {
    // Declare attributes here
    int itemId = 0;
    int itemWeight = 0;
    String itemDurability = null;
    String itemName = null;
    float itemValue = 0;
    
    public Item()
    {
        
    }
    
    
    // Create an overridden constructor here
    
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
    
    public float getItemValue()
    {
        
        return itemValue;
    }
}
