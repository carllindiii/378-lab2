import greenfoot.*;

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Enemy
{
    public static final int SPEED = 1;
    
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        walk();
        checkKill(this);
    }
    
    /**
     * Walk around and do things
     */
    private void walk()
    {
        randomWalk();
    }
    
    /**
     * Random walking
     */
    private void randomWalk()
    {
        move(SPEED);
        if (Greenfoot.getRandomNumber(100) < 25)
        {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
        {
            turn(180);
        }
    }
    
    /**
     * Kill the ant and remove it from the world
     */
    /*private void checkKill()
    {
        Actor Ant = getOneIntersectingObject(Ant.class);
        //if (Greenfoot.mouseClicked(this))
        if((this) && Greenfoot.mouseClicked(null))
        {
            getWorld().removeObject(this);
        }
    }*/
   
}    