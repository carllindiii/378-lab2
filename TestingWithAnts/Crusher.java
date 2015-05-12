import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Crusher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crusher extends Spawnables
{
    public static final int RANGE = 70; // Hit-detection range
    
    public GreenfootImage fistImg;
    
    /**
     * Constructor
     */
    public Crusher()
    {
        fistImg = new GreenfootImage("CrushingFist.png");
        fistImg.scale(fistImg.getWidth(), fistImg.getHeight());
        
        setImage(fistImg);
    }
    
    
    /**
     * Act - do whatever the Crusher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        if (Greenfoot.mouseClicked(null))
        {
            crush();
        }
    }
    
    /**
     * What to do after the mouse is clicked
     */
    private void crush()
    {
        List ants = getObjectsInRange(RANGE, Enemy.class);
        setting w = (setting)getWorld();
        
        // Play sound effect of fist slamming into the grassy ground
        Greenfoot.playSound("fistCrushGrass.mp3");
        
        w.score += ants.size();
        w.removeObjects(ants);
        removeSpawnable();
    }
}
