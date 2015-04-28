import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;

/**
 * Write a description of class antlio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class antlio extends Actor
{
    /**
     * Act - do whatever the antlio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     /** Random number generator. */
    private static final Random randomizer = AntWorld.getRandomizer();

     /** the speed the ant moves with - in pizels per update. */
    private static final int SPEED = 3;
    
     //current movement
    private int deltaX = 0;
    private int deltaY = 0;
    private int antsEaten;
    public antlio()
    {
        antsEaten =0;
    }

 
    
    public void act() 
    {
        // Add your action code here.
        if(foundAnt()) {
            eatAnt();
        }
        else
        if(foundAntlio()) {
             if (Greenfoot.getRandomNumber(100) <= 2)
             {
            eatAntlio();
        }
        walk();
        walk();
        walk();
        walk();
        walk();
        }
        else {
        walk();
    }    }
    
     private void walk()
    {
            randomWalk();
      
    }
    private void randomWalk()
    {
        if (randomChance(50)) {
            deltaX = adjustSpeed(deltaX);
            deltaY = adjustSpeed(deltaY);
        }
        move();
    }
     private int adjustSpeed(int speed)
    {
        speed = speed + randomizer.nextInt(2 * SPEED - 1) - SPEED + 1;
        return capSpeed(speed);
    }
     private int capSpeed(int speed)
    {
        if (speed < -SPEED)
            return -SPEED;
        else if (speed > SPEED)
            return SPEED;
        else
            return speed;
    }
     private void move()
    {
        try {
            setLocation(getX() + deltaX, getY() + deltaY);
        }
        catch (IndexOutOfBoundsException e) {
            // We don't care - just leave it
        }
        setRotation((int) (180 * Math.atan2(deltaY, deltaX) / Math.PI));
    }
     private boolean randomChance(int percent)
    {
        return randomizer.nextInt(100) < percent;
    }
    
    
    //eat codeeeee
    public boolean foundAnt()
    {
        Actor Ant = getOneObjectAtOffset(0, 0, Ant.class);
        if(Ant != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Eat a Ant.
     */
    public void eatAnt()
    {
        Actor Ant = getOneIntersectingObject(Ant.class);
        if(Ant != null) {
            // eat the Ant...
            getWorld().removeObject(Ant);
            antsEaten = antsEaten + 1; 
            if (antsEaten >= 10)
            {
                antsEaten=0;
                int f = Greenfoot.getRandomNumber(1000);
                antlio fh = new antlio();
        getWorld().addObject(fh, getX(), getY());
       
            }
        }
    }
    
    
     public boolean foundAntlio()
    {
        Actor antlio = getOneObjectAtOffset(0, 0, antlio.class);
        if(antlio != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Eat a Ant.
     */
    public void eatAntlio()
    {
        Actor antlio = getOneIntersectingObject(antlio.class);
        if(antlio != null) {
            // eat the Ant...
      if (Greenfoot.getRandomNumber(100) <= 90)
      {
          getWorld().removeObject(antlio);
            antsEaten = antsEaten + 1; 
            Food fd = new Food();
        getWorld().addObject(fd, getX(), getY());
             fight ff = new fight();
        getWorld().addObject(ff, getX(), getY());
      
        }
            
        }
    
    }
    
   
          
}
