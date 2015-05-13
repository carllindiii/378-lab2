import greenfoot.*;

/**
 * Write a description of class NinjaAnt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NinjaAnt extends StealthAnt
{
    GreenfootImage img;
    protected static final int STEALTH_DELAY = 100;
    protected int delay;
    
    protected boolean stealth;
    
    public NinjaAnt() {
        super();
        SPEED = 2;
        img = new GreenfootImage("NinjaAnt.png");
        setImage(img);
    }
    
    public NinjaAnt(int takeSpeed) {
        super(takeSpeed);
        SPEED = 2;
        img = new GreenfootImage("NinjaAnt.png");
        setImage(img);
    }
    
    /**
     * Act - do whatever the NinjaAnt wants to do. This method is called whenever
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
