import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Spark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spark extends AnimatedActor
{
    public static final int CYCLE = 20; // Total cycles needed to complete 1 animation loop
    public static final int ALTERNATE = 4;
    public static final int HIT_RADIUS = 120; // Radius range for getObjectsInRange()
    
    public int sparkTime;
    /**
     * Spark Constructor
     */
    public Spark()
    {
        super("spark", ".png", 6);
        sparkTime = CYCLE - 1;
        
        // Scale the spark images
        for (GreenfootImage img : images)
        {
            img.scale(img.getWidth() - 250, img.getHeight() - 250);
        }
    }
    
    /**
     * Act - do whatever the Spark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (sparkTime > 0)
        {
            // Zap all intersecting enemies ONCE
            if (sparkTime == CYCLE - 1) // should only get called ONCE
            {
                Greenfoot.playSound("loudPop.mp3"); // play the loud popping sound once
                zap();
            }
            
            // Animate spark every ALTERNATE cycles
            if (sparkTime % ALTERNATE == 0)
            {
                super.act();
            }
            sparkTime--;
        }
        else
        {
            w.removeObject(this);
        }
    }    
    
    /**
     * Zaps all intersecting enemies (eliminating them)
     */
    public void zap()
    {
        List enemies = getObjectsInRange(HIT_RADIUS, Enemy.class);
        setting w = (setting)getWorld();
        
        w.score += enemies.size();
        w.wave_score += enemies.size();
        w.removeObjects(enemies);
    }
}
