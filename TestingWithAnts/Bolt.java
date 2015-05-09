import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Bolt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bolt extends AnimatedActor
{    
    public static final int CYCLE_COUNT = 3; // Number of animation loops
    public static final int CYCLE = 56; // Time needed for 1 animation cycle
    public static final int DELAY = 20; // Added cycle delay between each bolt animation loop
    public static final int ALTERNATE = 4;
    /* IMPORTANT: CYCLE AND DELAY MUST ALWAYS HAVE A DIFFERENCE OF 36 */
    
    
    public GreenfootImage delayImg;
    public int boltTime;
    /**
     * Lightning Bolt Strike Constructor
     */
    public Bolt()
    {
        super("bolt", ".png", 10);
        boltTime = CYCLE * CYCLE_COUNT - 1;
        
        // This will be an invisible image that is set during the delay between bolt animation loops
        delayImg = new GreenfootImage("boltdelay.png"); 
        delayImg.setTransparency(0);
        
        // Scale the Bolt images
        for (GreenfootImage img : images)
        {
            img.scale(img.getWidth(), img.getHeight() - 70);
        }
    }
    
    /**
     * Act - do whatever the Bolt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (boltTime <= 0)
        {
            w.removeObject(this);
        }
        else
        {
            // Play bolt sound effect once per animation cycle
            if (boltTime % CYCLE == CYCLE - 1)
            {
                Greenfoot.playSound("boltStrike2.mp3");
            }
            
            // Animate the bolt every ALTERNATE method calls
            if (boltTime % ALTERNATE == 0 && (boltTime % CYCLE) >= DELAY)
            {
                super.act();
                electrocute();
            }
            // Set the image to our transparent image during the delay between bolt
            else if ((boltTime % CYCLE) < DELAY)
            {
                setImage(delayImg);
            }
            
            boltTime--;
        }
    }  
    
    /**
     * Electrocute and kill all enemies in range
     */
    public void electrocute()
    {
        List enemies = getIntersectingObjects(Enemy.class);
        setting w = (setting)getWorld();
        
        w.score += enemies.size();
        w.removeObjects(enemies);
    }
}
