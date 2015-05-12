import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Flame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flame extends AnimatedActor
{
    public static final int FLAME_TIME_LIMIT = 200;
    public static final int ALTERNATE = 4;
    
    public int timeOnFire;
    public GreenfootSound flameSound;
    /**
     * Constructor for the flame
     */
    public Flame()
    {
        super("Flame", ".png", 6);
        timeOnFire = FLAME_TIME_LIMIT;        
        
        flameSound = new GreenfootSound("flames.mp3");
        flameSound.play(); // Start playing the sound effect as soon as this is created
        
        // Scale the flame images
        for (GreenfootImage image : images)
        {
            image.scale(image.getWidth() - 80, image.getHeight() - 120);
        }
    }
    
    /**
     * Act - do whatever the Flame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        if (timeOnFire <= 0)
        {
            flameSound.stop(); // Stop the flame sound effect
            w.removeObject(this);
        }
        else
        {
            // animate the flames every ALTERNATE # of cycles
            if (timeOnFire % ALTERNATE == 0)
            {
                super.act();
            }
            
            burn(); // burn and remove the ants
            timeOnFire--;
        }
    }
    
    /**
     * Incinerate all enemies that intersect with this flame
     */
    public void burn()
    {
        List enemies = getIntersectingObjects(Enemy.class);
        setting w = (setting)getWorld();
        
        w.score += enemies.size();
        w.wave_score += enemies.size();
        w.removeObjects(enemies);
    }
}
