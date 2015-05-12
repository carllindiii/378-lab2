import greenfoot.*;

/**
 * Write a description of class TidalWaveOverlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TidalWaveOverlay extends TidalWave
{
    public TidalWave followThis;
    
    /**
     * Tidal Wave Overlay Image Constructor
     */
    public TidalWaveOverlay(TidalWave toFollow)
    {
        setImage(new GreenfootImage("tidalWave.png"));
        
        followThis = toFollow;
    }
    
    /**
     * Act - do whatever the TidalWaveOverlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (getX() >= w.getWidth() - 2)
        {
            w.removeObject(this);
        }
        else
        {
            setLocation(followThis.getX(), followThis.getY());
        }
    }    
}
