import greenfoot.*;
import java.util.LinkedList;

/**
 * Write a description of class DropSparks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropSparks extends FireCracker
{
    public static final int CYCLE_DELAY = 20; // # of cycle delays between each spark
    
    public Spark firstSpark;
    public int delayTime;
    public boolean isFirstSpark;
    public LinkedList<Spark> sparks;
    /**
     * DropSparks Constructor
     */
    public DropSparks(LinkedList<Spark> sparksFromParent)
    {
        delayTime = CYCLE_DELAY;
        
        // Set this to an invisible junk image
        GreenfootImage img = new GreenfootImage("spark0.png");
        img.setTransparency(0);
        setImage(img);
        
        // Assign our sparks array to the parent's
        sparks = sparksFromParent;
        
        // Setup the first spark for later use
        firstSpark = sparks.pop();
        isFirstSpark = true;        
    }
    
    /**
     * Act - do whatever the DropSparks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        // Call in Sparks if there are still some remaining
        if (sparks.size() > 0)
        {
            // Delay
            if (delayTime > 0)
            {
                delayTime--;
            }
            // Drop a Spark
            else
            {
                // Drop the 1st Spark on the location without any randomization
                if (isFirstSpark == true)
                {
                    w.addObject(firstSpark, this.getX(), this.getY());
                    isFirstSpark = false;
                }
                // Drop the current spark with some randomized location
                else
                {
                    w.addObject(sparks.pop(), 
                                this.getX() + (Greenfoot.getRandomNumber(RANGE) - RANGE / 2), 
                                this.getY() + (Greenfoot.getRandomNumber(RANGE) - RANGE / 2));
                }
                // reset the delay timer
                delayTime = CYCLE_DELAY;
            }
        }
        // Remove this once all sparks have been called in
        else
        {
            w.removeObject(this);
        }
    }    
}
