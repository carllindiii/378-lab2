import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Score
{
    public int score;
    GreenfootImage text;
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        setting w = (setting)getWorld();
        score = w.score;
        
        text = new GreenfootImage("Kills: " + score, 20, Color.WHITE, null);
        setImage(text);
    }    
}