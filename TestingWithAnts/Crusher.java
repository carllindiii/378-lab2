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
    
    static final int crushPower = 20;
    
    /**
     * Act - do whatever the Crusher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();        
        if (Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            List<Powerbar> powerbarList = (List<Powerbar>) w.getObjects(Powerbar.class);
            Powerbar powerbar = powerbarList.get(0);
            
            crush();
            //This is going to be called multiple times....... we should fix it
            System.out.println("remove power: " + crushPower);
            powerbar.removePower(crushPower);    
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
        List ants = getIntersectingObjects(Enemy.class);
        setting w = (setting)getWorld();
        
        w.score += ants.size();
        w.removeObjects(ants);
        //getWorld().removeObjects(getObjectsInRange(50, Ant.class));
        w.removeObject(this);
    }
}
