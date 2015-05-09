import greenfoot.*;

/**
 * Write a description of class GlueIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GlueIcon extends Glue
{
    public GreenfootImage unavailable;
    public GreenfootImage available;
    
    /**
     * Constructing the GlueIcon
     */
    public GlueIcon()
    {
        unavailable = new GreenfootImage("Scorestreak_Icon_Glue_Inactive.png");
        available = new GreenfootImage("Scorestreak_Icon_Glue.png");
        
        setImage(unavailable);
    }
    /**
     * Act - do whatever the GlueIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        Powerbar pb = w.powerbar;
        
        if (pb.getPower() >= GLUE_COST)
        {
            setImage(available);
        }
        else
        {
            setImage(unavailable);
        }
    }    
}
