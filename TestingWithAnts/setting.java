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
        PicnicBlanket picnicblanket = new PicnicBlanket();
        addObject(picnicblanket, 30, 495);

        Spawner spawner = new Spawner();
        addObject(spawner, 663, 91);

        Spawnables spawnables = new Spawnables();
        addObject(spawnables, 400, 550);

        Food food = new Food();
        addObject(food, 107, 431);

        FoodCounter fc = new FoodCounter();
        addObject(fc, food.getX(), food.getY() + 25);

        Scoreboard power = new Scoreboard();
        addObject(power, 55, 525);

        AntHome anthome = new AntHome();
        addObject(anthome, 730, 450);

        Ant ant = new Ant();
        addObject(ant, 215, 160);

        Powerbar powerbar = new Powerbar();
        addObject(powerbar, 60, 565);

        MatchIcon matchicon = new MatchIcon();
        addObject(matchicon, 160, 576);

        CrusherIcon crushericon = new CrusherIcon();
        addObject(crushericon, 160, 532);
    }
}
