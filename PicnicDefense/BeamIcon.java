import greenfoot.*;

/**
 * Write a description of class BeamIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeamIcon extends Beamer
{
    public GreenfootImage unavailable;
    public GreenfootImage available;
    
    /**
     * BeamIcon Constructor
     */
    public BeamIcon()
    {
        unavailable = new GreenfootImage("Scorestreak_Icon_Beam_Inactive.png");
        available = new GreenfootImage("Scorestreak_Icon_Beam.png");
        
        //unavailable.scale(unavailable.getWidth() + 20, unavailable.getHeight() + 20);
        //available.scale(available.getWidth() + 20, available.getHeight() + 20);
        
        setImage(unavailable);
    }
    
    /**
     * Act - do whatever the BeamIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();        
        Powerbar powerbar = w.powerbar; // assign to state variable 'powerbar' in setting
        
        if (powerbar.getPower() >= BEAM_COST)
        {
            setImage(available);
        }
        else
        {
            setImage(unavailable);
        }
    }    
}
