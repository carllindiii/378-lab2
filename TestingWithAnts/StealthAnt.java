import greenfoot.*;

/**
 * Write a description of class StealthAnt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StealthAnt extends Ant
{
    GreenfootImage img;
    private static final int STEALTH_DELAY = 100;
    private int delay;
    
    private boolean stealth;
    
    public StealthAnt() {
        super();
        img = new GreenfootImage("StealthAnt.png");
        setImage(img);
        delay = 0;
        stealth = false;
    }
    
    /**
     * Act - do whatever the StealthAnt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        if (delay >= 100) {
            delay = 0;
            if (stealth) {
                img.setTransparency(100);
                stealth = false;
            }
            else {
                img.setTransparency(255);
                stealth = true;
            }
        }
        
        delay++;
    }    
}
