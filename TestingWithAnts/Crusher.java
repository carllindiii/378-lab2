import greenfoot.*;

/**
 * Write a description of class Crusher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crusher extends Spawnables
{
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
     * Crusher actor follows the mouse
     */
    private void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        if (mi != null)
        {
            setLocation(mi.getX(), mi.getY());
        }
    }
    
    /**
     * What to do after the mouse is clicked
     */
    private void crush()
    {
        getWorld().removeObjects(getIntersectingObjects(Ant.class));
        //getWorld().removeObjects(getObjectsInRange(50, Ant.class));
        getWorld().removeObject(this);
    }
}
