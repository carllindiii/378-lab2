import greenfoot.*;
import java.util.LinkedList;

/**
 * Write a description of class FireCracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireCracker extends Spawnables
{
    public static final int MIN_SPARKS = 4; // the minimum amount of sparks per Fire Cracker
    public static final int RANGE = 300; // randomness range for location of where sparks get added
    
    public int totalSparks;
    public LinkedList<Spark> sparks;
    
    /**
     * Fire Cracker Constructor
     */
    public FireCracker()
    {
        setImage(new GreenfootImage("button-purple.png"));
        totalSparks = Greenfoot.getRandomNumber(4) + MIN_SPARKS;
        sparks = new LinkedList<Spark>();
    }
    
    /**
     * Act - do whatever the FireCracker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        
        if (Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            
            for (int i = 0; i < totalSparks; i++)
            {
                sparks.add(new Spark());
            }
            
            //addSparks();
            DropSparks drop = new DropSparks(sparks);
            w.addObject(drop, this.getX(), this.getY());
            removeSpawnable();
        }
    }
}
