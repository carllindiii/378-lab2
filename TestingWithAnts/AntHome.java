import greenfoot.*;

public class AntHome extends Actor
{
    public GreenfootImage img;
    
    /**
     * Constructor
     */
    public AntHome()
    {
        // Set junk image that will be invisible
        img = new GreenfootImage("apple1.png");
        img.setTransparency(0);
        setImage(img);
    }
    
    public void act()
    {
    } 
}