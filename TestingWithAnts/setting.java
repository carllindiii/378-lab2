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
        super(800, 600, 1); 
        score = 0;
        prepare();
    }
    
    /**
     * Prepare the world
     */
    public void prepare()
    {   
        //HUD
        Hudbar hudbar = new Hudbar();
        addObject(hudbar, 400, 550);
        Powerbar powerbar = new Powerbar();
        addObject(powerbar, 120, 560);
        Scoreboard sb = new Scoreboard();
        addObject(sb, 45, 525);
        // HUD powerups
        Crusher_hud crusher_hud = new Crusher_hud();
        addObject(crusher_hud, 300, 540);
        
        //Hidden object to spawn powerups
        Spawnables spawnables = new Spawnables();
        addObject(spawnables, 32, 33);

        Spawner spawner = new Spawner();
        addObject(spawner, 700, 100);
        AntHome anthome = new AntHome();
        addObject(anthome, 730, 400);

        Food food = new Food();
        addObject(food, 100, 400);
        FoodCounter fc = new FoodCounter();
        addObject(fc, food.getX(), food.getY() + 25);
    }
}
