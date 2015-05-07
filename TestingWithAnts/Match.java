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
     * Construct the Match
     */
    public Match()
    {
        setImage(new GreenfootImage("Match stick.png"));
    }
    
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
            removeSpawnable();
            //w.removeObject(this);
        }
    }
}
