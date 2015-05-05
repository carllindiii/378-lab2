import greenfoot.*;

/**
 * Write a description of class Spawnables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawnables extends Actor
{
    /**
     * Construct the Spawnables
     */
    public Spawnables()
    {
        setImage(new GreenfootImage("Bottom HUD.png"));
    }
    
    /**
     * Act - do whatever the Spawnables wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        //if (Greenfoot.getKey() == "1")
        if (Greenfoot.isKeyDown("1"))
        {
            Crusher crush = new Crusher();
            getWorld().addObject(crush, mi.getX(), mi.getY());
        }
        else if (Greenfoot.isKeyDown("2"))
        {
            Match match = new Match();
            getWorld().addObject(match, mi.getX(), mi.getY());
        }
    }    
    
    /**
     * Spawnable actor follows the mouse
     */
    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        if (mi != null)
        {
            setLocation(mi.getX(), mi.getY());
        }
    }
}
