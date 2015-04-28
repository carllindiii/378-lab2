import greenfoot.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Checks if the mouse is on the enemy
     */
    private boolean mouseOnEnemy(Actor actor)
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        return mouse != null && mouse.getX() > actor.getX() - actor.getImage().getWidth()*2 && mouse.getX() < actor.getX() + actor.getImage().getWidth()*2 && 
            mouse.getY() > actor.getY() - actor.getImage().getHeight()*2 && mouse.getY() < actor.getY() + actor.getImage().getHeight()*2;
    }

    /**
     * Kill the actor and remove it from the world
     */
    public void checkKill(Actor actor)
    {
        if(mouseOnEnemy(actor) && Greenfoot.mouseClicked(null))
        {
            setting w = (setting)getWorld();
            w.score += 1;
            
            w.removeObject(actor);
        }
    }
    
    public void killAnts() {
        setting w = (setting)getWorld();
        w.score += 1;
        w.removeObject(this);
    }
}
