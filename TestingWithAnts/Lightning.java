import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Lightning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lightning extends Spawnables
{
    /**
     * Constructor
     */
    public Lightning()
    {
        setImage(new GreenfootImage("button-purple.png"));
    }
    
    /**
     * Act - do whatever the Lightning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        
        if (Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            Bolt bolt = new Bolt();
            
            w.addObject(bolt, this.getX(), this.getY());
            removeSpawnable();
        }
    }    
}
