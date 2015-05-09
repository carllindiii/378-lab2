import greenfoot.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public int multiplier = 2;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
    }    
    
    /**
     * Checks if the mouse is on the enemy
     */
    protected boolean mouseOnEnemy(Actor actor)
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        return mouse != null && 
            mouse.getX() > actor.getX() - actor.getImage().getWidth()*multiplier && 
            mouse.getX() < actor.getX() + actor.getImage().getWidth()*multiplier && 
            mouse.getY() > actor.getY() - actor.getImage().getHeight()*multiplier && 
            mouse.getY() < actor.getY() + actor.getImage().getHeight()*multiplier;
    }

    /**
     * Kill the actor and remove it from the world
     */
    public void checkKill(Actor actor, int pointsToAdd)
    {
        if(mouseOnEnemy(actor) && Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            
            w.score += pointsToAdd;
            w.removeObject(actor);
        }
    }
}
