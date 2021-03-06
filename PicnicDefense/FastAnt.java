import greenfoot.*;

/**
 * HAD TO COPY ANT CLASS to allow ALL FAST ants to survive the beam scorestreak!!
 * 
 */
public class FastAnt extends Enemy
{    
    // FINAL VARIABLES
    public static final int SPEED = 2; // ant speed
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
    
    public FastAnt()
    {
        canMove = true;
        hasFood = false;
        takeTimer = TAKE_TIME;
        dropTimer = DROP_TIME;
        GreenfootImage img = new GreenfootImage("FastAnt.png");
        setImage(img);
    }
    
    public FastAnt(int takeSpeed)
    {
        canMove = true;
        hasFood = false;
        takeTimer = takeSpeed;
        dropTimer = DROP_TIME;
        GreenfootImage img = new GreenfootImage("FastAnt.png");
        setImage(img);
    }
    
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        if (w.isPaused == false) {
            if (canMove == true)
            {
                walk();
            }
            checkKill(this, POINT_VALUE);
        }
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
            if (Greenfoot.getRandomNumber(1000) < 400)
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
}
