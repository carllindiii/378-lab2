import greenfoot.*;

/**
 * Write a description of class TidalWaveIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TidalWaveIcon extends Spawnables
{
    public GreenfootImage unavailable;
    public GreenfootImage available;
    
    /**
     * Tidal Wave Icon Constructor
     */
    public TidalWaveIcon()
    {
        unavailable = new GreenfootImage("Scorestreak_Icon_Tidal_Wave_Inactive.png");
        available = new GreenfootImage("Scorestreak_Icon_Tidal_Wave.png");
        
        setImage(unavailable);
    }
    /**
     * Act - do whatever the TidalWaveIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        Powerbar pb = w.powerbar;
        
        if (pb.getPower() >= TIDAL_WAVE_COST)
        {
            setImage(available);
        }
        else
        {
            setImage(unavailable);
        }
    }    
}
