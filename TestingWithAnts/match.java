import greenfoot.*;

/**
 * Write a description of class match here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Match extends Spawnables
{
    public static final int FIRE_TIME_LIMIT = 100;
    
    /**
     * Act - do whatever the match wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        
        if (Greenfoot.mouseClicked(null))
        {
            Flame flame = new Flame();
            setting w = (setting)getWorld();
            
            w.addObject(flame, this.getX(), this.getY());
            w.removeObject(this);
        }
    }
    
    /**
     * Ignite the fire for a certain amount of time and then remove it
     * /
    public void ignite()
    {
        int timeOnFire = 0;
        
        setImage(new GreenfootImage("button-purple.png"));
        
        // Call the burn method for the duration of the fire time limit
        while (timeOnFire < FIRE_TIME_LIMIT)
        {
            burn();
            timeOnFire++;
        }
        
        if (timeOnFire >= FIRE_TIME_LIMIT)
        {
            timeOnFire = 0;
            w.removeObject(this);
        }
    }*/
    
    /**
     * Burn and remove the enemies
     * /
    public void burn()
    {
        // Initialization of enemies and our world (setting)
        List enemies = getIntersectingObjects(Enemy.class);
        
        w.score += enemies.size();
        w.removeObjects(enemies);
    }*/
}
