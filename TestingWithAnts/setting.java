import greenfoot.*;

/**
 * Write a description of class setting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class setting extends World
{   
    /* Important variables carrying the state of the game */
    public int score;
    public Food food;
    public Powerbar powerbar;
    
    /**
     * Constructor for objects of class setting.
     * 
     */
    public setting()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // State variables initialization
        score = 0;
        food = new Food();
        powerbar = new Powerbar();
        
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
        addObject(spawner, 570, 115);

        Spawnables spawnables = new Spawnables();
        addObject(spawnables, 400, 550);

        // Add food to world
        addObject(food, 107, 431);

        FoodCounter fc = new FoodCounter();
        addObject(fc, food.getX(), food.getY() + 25);

        Scoreboard scoreboard = new Scoreboard();
        addObject(scoreboard, 535, 575);

        AntHome anthome = new AntHome();
        addObject(anthome, 730, 450);

        Ant ant = new Ant();
        addObject(ant, 215, 160);

        // Add powerbar to world
        addObject(powerbar, 60, 565);

        MatchIcon matchicon = new MatchIcon();
        addObject(matchicon, 160, 576);

        CrusherIcon crushericon = new CrusherIcon();
        addObject(crushericon, 160, 532);

        TreeStump treestump = new TreeStump();
        addObject(treestump, 567, 159);
        treestump.setLocation(638, 126);

        TempWavesHUD tempwaveshud = new TempWavesHUD();
        addObject(tempwaveshud, 70, 65);

        PowerScore powerscore = new PowerScore();
        addObject(powerscore, powerbar.getX() - 5, powerbar.getY() - 35);
    }
}
