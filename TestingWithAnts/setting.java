import greenfoot.*;

/**
 * Write a description of class setting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class setting extends World
{   
    public int score;
    /**
     * Constructor for objects of class setting.
     * 
     */
    public setting()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        score = 0;
        prepare();
    }
    
    /**
     * Prepare the world
     */
    public void prepare()
    {   
        Ant ant = new Ant();
        addObject(ant, 215, 160);
        Spawner spawner = new Spawner();
        addObject(spawner, 449, 103);
        Spawnables spawnables = new Spawnables();
        addObject(spawnables, 36, 37);
        
        Scoreboard sb = new Scoreboard();
        addObject(sb, 50, 10);
        
        Food food = new Food();
        addObject(food, 60, 268);
    }
}
