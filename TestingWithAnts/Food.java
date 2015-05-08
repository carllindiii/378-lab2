import greenfoot.*;

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends AnimatedActor
{
    public static final int FOOD_COUNT = 35;
    
    /* Instance Variables */
    public int count;
    public setting world;
    
    /**
     * Constructor for Food
     */
    public Food()
    {
        super("picnic_food", ".png", 7);
        world = (setting)getWorld();
        count = FOOD_COUNT;
        
        // scale it the food images
        for(GreenfootImage img : images) 
        {
            img.scale(img.getWidth() - 70, img.getHeight() - 70);
        }
    }
    
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();
    }

    /**
     * Update this object
     */
    public void update()
    {
        if(count <= 0) {
           world.removeObject(this); 
        }
        else
        {
           setImage(images[(count / 7) + 1]); 
        }
    }
    
    /**
     * Take some food
     */
    public void takeSome(int amount)
    {
        if (count - amount >= 0)
        {
            count -= amount;
        }
        else
        {
            count = 0;
        }
    }
    
    /**
     * Simple 'get' method to get count
     */
    public int getCount()
    {
        return count;
    }
}
