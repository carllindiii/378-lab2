import greenfoot.*;
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class PowerScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerScore extends Score
{
    GreenfootImage text;
    
    /**
     * Act - do whatever the PowerScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        Powerbar powerbar = w.powerbar;
        
        text = new GreenfootImage("Power: " + powerbar.getPower(), 20, Color.WHITE, null);
        setImage(text);
    }    
}
