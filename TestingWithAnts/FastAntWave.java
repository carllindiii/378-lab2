import greenfoot.*;

/**
 * Write a description of class FastAntWave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastAntWave extends Background
{
    private static final int TIME_ON_SCREEN = 300;
    private int delay;
    private boolean transparent;
    GreenfootImage img;
    
    public FastAntWave() {
        img = new GreenfootImage("FastAntWave.png");
        setImage(img);
        delay = 0;
        transparent = false;
    }
    
    /**
     * Act - do whatever the FastAntWave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (delay % 50 == 0 && delay != 0) {
            if (!transparent) {
                img.setTransparency(0);
                transparent = true;
            }
            else {
                img.setTransparency(255);
                transparent = false;
            }
        }
        
        
        delay++;
        if (delay == TIME_ON_SCREEN)
            w.removeObject(this);
    }    
}
