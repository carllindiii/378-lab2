import greenfoot.*;

/**
 * Write a description of class CreditsScroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsScroll extends Background
{
    public CreditsScroll() {
        // Set credits scroll to the image of the credits
        GreenfootImage img = new GreenfootImage("Face9_satisfied.png");
        setImage(img);
    }
    
    /**
     * Act - do whatever the CreditsScroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - 1);
    }    
}
