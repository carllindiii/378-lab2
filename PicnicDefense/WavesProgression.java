import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class WavesProgression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WavesProgression extends Score
{
    public int score;
    public int denominator;
    GreenfootImage text;
   
    public WavesProgression(int reach_score) {
        denominator = reach_score;
    }
    
    /**
     * Act - do whatever the WavesProgression wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        score = w.wave_score;
        
        text = new GreenfootImage(score + "/" + denominator, 26, Color.WHITE, null);
        setImage(text);
    }    
}
