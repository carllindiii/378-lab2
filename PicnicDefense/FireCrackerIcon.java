import greenfoot.*;

/**
 * Write a description of class FireCrackerIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireCrackerIcon extends FireCracker
{
    public GreenfootImage unavailable;
    public GreenfootImage available;
    
    /**
     * Fire Cracker Scorestreak Icon Constructor
     */
    public FireCrackerIcon()
    {
        unavailable = new GreenfootImage("Scorestreak_Icon_Fire_Cracker_Inactive.png");
        available = new GreenfootImage("Scorestreak_Icon_Fire_Cracker.png");
        
        setImage(unavailable);
    }
    
    /**
     * Act - do whatever the FireCrackerIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        Powerbar pb = w.powerbar;
        
        if (pb.getPower() >= FIRE_CRACKER_COST)
        {
            setImage(available);            
        }
        else
        {
            setImage(unavailable);
        }
    }    
}
