import greenfoot.*;

/**
 * Write a description of class Glue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Glue extends Spawnables
{
    /**
     * Constructor
     */
    public Glue()
    {
        setImage(new GreenfootImage("button-purple.png"));
    }
    
    /**
     * Act - do whatever the Glue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        
        if (Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            GluePile gp = new GluePile();
            
            w.addObject(gp, this.getX(), this.getY());
            removeSpawnable();
        }
    }    
}
