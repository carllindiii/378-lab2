import greenfoot.*;

/**
 * Write a description of class BoltIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoltIcon extends Lightning
{
    public GreenfootImage unavailable;
    public GreenfootImage available;
    
    /**
     * BoltIcon Constructor
     */
    public BoltIcon()
    {
        unavailable = new GreenfootImage("Scorestreak_Icon_Bolt_Inactive.png");
        available = new GreenfootImage("Scorestreak_Icon_Bolt.png");
        
        setImage(unavailable);
    }
    
    /**
     * Act - do whatever the BoltIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        Powerbar pb = w.powerbar;
        
        if (pb.getPower() >= BOLT_COST)
        {
            setImage(available);
        }
        else
        {
            setImage(unavailable);
        }
    }    
}
