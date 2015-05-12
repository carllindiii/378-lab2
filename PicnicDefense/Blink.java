import greenfoot.*;

/**
 * Write a description of class Blink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blink extends FacialExpression
{
    public static final int BLINK_DELAY = 15; // Number of Cycles of delay
    
    public GreenfootImage blink1;
    public int timer;
    /**
     * Constructor
     */
    public Blink(int variation)
    {
        blink1 = faces[variation];
        timer = BLINK_DELAY;
        
        setImage(blink1);
    }
    /**
     * Act - do whatever the Blink wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (timer > 0)
        {
            timer--;
        }
        else
        {
            setting w = (setting)getWorld();
            w.removeObject(this);
        }
    }    
}
