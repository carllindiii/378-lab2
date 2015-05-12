import greenfoot.*;
import java.util.List;

/**
 * Write a description of class CrusherIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrusherIcon extends Crusher
{
    //public static final int TEMP_COST = 10;
    
    public GreenfootImage unavailable;
    public GreenfootImage available;
    
    /**
     * Constructing the CrusherIcon
     */
    public CrusherIcon()
    {
        unavailable = new GreenfootImage("Scorestreak_Icon_Crusher_Inactive.png");
        available = new GreenfootImage("Scorestreak_Icon_Crusher.png");
        
        setImage(unavailable);
    }
    
    /**
     * Act - do whatever the CrusherIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();        
        Powerbar powerbar = w.powerbar; // assign to state variable 'powerbar' in setting
        
        if (powerbar.getPower() >= CRUSHER_COST)
        {
            setImage(available);
        }
        else
        {
            setImage(unavailable);
        }
    }    
}
