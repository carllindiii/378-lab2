import greenfoot.*;

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Enemy
{
    // FINAL VARIABLES
    public static final int SPEED = 1; // ant speed
    public static final int TAKE_TIME = 30; // number of cycles (in timer) to take food
    public static final int DROP_TIME = 180; // number of cycles to drop food
    public static final int POINT_VALUE = 1;
    
    // If Ant has food
    public boolean hasFood;
    
    // Boolean allowing the ant to move
    public boolean canMove;
    
    // Timers
    public int takeTimer; // when ant is trying to take food
    public int dropTimer; // when ant is dropping the food
    
    public Ant()
    {
        canMove = true;
        hasFood = false;
        takeTimer = TAKE_TIME;
        dropTimer = DROP_TIME;
    }
    
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (canMove == true)
        {
            walk();
        }
        checkKill(this, POINT_VALUE);
    }
    
    /**
     * Walk around and do things
     */
    private void walk()
    {
        if (hasFood == false) // DOESN'T HAVE food
        {
            smellFood();
        }
        else // HAS food
        {
            headHome();
        }
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
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 105)
        {
            turn(180);
        }
    }
    
    /**
     * Turn towards the food
     */
    public void smellFood()
    {
        Food food = null;
        
        // Ant is on top of the food
        if (getObjectsInRange(20, Food.class).isEmpty() == false)
        {
            if (Greenfoot.getRandomNumber(1000) < 500)
            {
                food = (Food)(getObjectsInRange(1700, Food.class).get(0));
                turnTowards(food.getX(), food.getY());
            }
        }
        // Ant is close to the food
        else if (getObjectsInRange(100, Food.class).isEmpty() == false)
        {
            if (Greenfoot.getRandomNumber(1000) < 150)
            {
                food = (Food)(getObjectsInRange(1700, Food.class).get(0));
                turnTowards(food.getX(), food.getY());
            }
        } 
        // Ant is getting close to the food
        else if (getObjectsInRange(200, Food.class).isEmpty() == false)
        {
            if (Greenfoot.getRandomNumber(1000) < 25)
            {
                food = (Food)(getObjectsInRange(200, Food.class).get(0));
                turnTowards(food.getX(), food.getY());
            }
        }
        // Ant is far from the food
        else if (getWorld().getObjects(Food.class).isEmpty() == false)
        {
            if (Greenfoot.getRandomNumber(1000) < 10)
            {
                food = (Food)(getWorld().getObjects(Food.class).get(0));
                turnTowards(food.getX(), food.getY());
            }
        }
        
        if (food != null && intersects(food) && hasFood == false)
        {
            takeFood(food);
        }
    }
    
    /**
     * Take some food after some time has past
     */
    public void takeFood(Food food)
    {
        if (takeTimer == 0)
        {
            hasFood = true;
            food.takeSome(Greenfoot.getRandomNumber(3) + 1);
            takeTimer = TAKE_TIME;
        }
        else
        {
            takeTimer--;
        }
    }
    
    /**
     * Head towards home
     */
    public void headHome()
    {
        AntHome home = null;
        
        // Just checking if there's a home
        if (getWorld().getObjects(AntHome.class).isEmpty() == false)
        {
            home = (AntHome)(getWorld().getObjects(AntHome.class).get(0));
            if (Greenfoot.getRandomNumber(1000) < 120)
            {
                turnTowards(home.getX(), home.getY());
            }
        }
        
        // check if ant has reached home
        if (home != null && intersects(home))
        {
            dropFood();
        }
    }
    
    /**
     * Ant drops the food after some time has past
     */
    public void dropFood()
    {
        if (dropTimer == 0)
        {
            hasFood = false;
            /* setImage("...") or something */
            dropTimer = DROP_TIME * 2;
        }
        else
        {
            dropTimer--;
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
