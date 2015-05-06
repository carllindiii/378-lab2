import greenfoot.*;

/**
 * Write a description of class Beamer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beamer extends Spawnables
{
    /**
     * Construct the Match
     */
    public Beamer()
    {
        setImage(new GreenfootImage("BeamPath.png"));
    }
    
    /**
     * Act - do whatever the Beamer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        
        if (Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            Beam beam = new Beam();
            
            w.addObject(beam, w.getWidth()/2, this.getY());
            w.removeObject(this);
        }
    }    
}
