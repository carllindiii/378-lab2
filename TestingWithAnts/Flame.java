import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Flame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flame extends Match
{
    public static final int FLAME_TIME_LIMIT = 200;
    public static final int ALTERNATE = 12;
    
    public int timeOnFire;
    
    // For the flame animation
    public GreenfootImage flame1;
    public GreenfootImage flame2;
    public GreenfootImage flame3;
    /**
     * Constructor for the flame
     */
    public Flame()
    {
        timeOnFire = FLAME_TIME_LIMIT;
        flame1 = new GreenfootImage("button-yellow.png");
        flame2 = new GreenfootImage("button-purple.png");
        flame3 = new GreenfootImage("pear.png");
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
            w.removeObject(this);
        }
        else
        {
            animate(timeOnFire);
            burn();
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
        w.removeObjects(enemies);
    }
    
    /**
     * Animate the flame by alternating the set images
     */
    public void animate(int value)
    {
        if (value % ALTERNATE == 8)
        {
            setImage(flame1);
            //setImage(new GreenfootImage("button-purple.png"));
        }
        else if (value % ALTERNATE == 4)
        {
            setImage(flame2);
            //setImage(new GreenfootImage("button-yellow.png"));
        }
        else if (value % ALTERNATE == 0)
        {
            setImage(flame3);
            //setImage(new GreenfootImage("pear.png"));
        }
    }
}
