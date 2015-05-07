import greenfoot.*;
import java.awt.Color;
import java.util.List;

public class FoodCounter extends Actor
{
    public GreenfootImage img;
    public setting w;
    public Food food;
    
    public void act()
    {
        updateImage();
    }
    
    public void updateImage()
    {
        int c;
        w = ((setting)getWorld());
        
        if (w.getObjects(Food.class).isEmpty() == false)
        {
            food = w.food; // assign food to the state variable food in setting
            c = w.food.getCount();
            
            if (c <= 0)
            {
                w.removeObject(food);
            }
        }
        else
        {
            c = 0;
            
            /* Temporarily disable game over so development doesn't get annoying
            w.endGame(); */
        }
        
        img = new GreenfootImage("Food Left: " + c, 20, Color.BLACK, null);
        setImage(img);       
    }
}