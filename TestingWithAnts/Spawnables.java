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
     * Act - do whatever the Spawnables wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        //if (Greenfoot.getKey() == "c")
        if (Greenfoot.isKeyDown("c")) {
            Crusher crush = new Crusher();
            getWorld().addObject(crush, mi.getX(), mi.getY());
        }
    }    
}
