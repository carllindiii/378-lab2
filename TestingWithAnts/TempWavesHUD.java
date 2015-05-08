import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TempWavesHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempWavesHUD extends Background
{
    GreenfootImage text;
    private int delay = 100;
    private int delayCounter = 0;
    
    public TempWavesHUD(int level) {
        text = new GreenfootImage("Wave: " + level + "!!", 50, Color.BLACK, null);
        setImage(text);
    }
    
    /**
     * Wave advancement is announced, drops down from top to middle of screen.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        if (getY() <= 475) {
            delayCounter++;
        }
        else {
            setLocation(getX(), getY() - 2);
        }
        
        if (delayCounter == delay)
            w.removeObject(this);
    }    
}
