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
    public int level;
    public WavesHUD wave;
    
    public static final int levelThreshold = 20; // Value used to determine points until next wave.
    
    PlayButton play = new PlayButton(1);
    public boolean isPaused;
    
    /* All Music for each wave */
    public GreenfootSound wave1Song;
    public GreenfootSound wave2Song;
    public GreenfootSound wave3Song;
    public GreenfootSound wave4Song;
    public GreenfootSound wave5Song;
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
        level = 1;
        wave = new WavesHUD(level);
        isPaused = false;
        
        /* Initializing all the music for each wave */
        wave1Song = new GreenfootSound("wave1Music_Track16.mp3");
        wave1Song.setVolume(50);
        wave2Song = new GreenfootSound("wave2Music_LifeOfRiley.mp3");
        wave2Song.setVolume(50);        
        wave3Song = new GreenfootSound("wave3Music_Hyperfun.mp3");
        wave3Song.setVolume(50);
        wave4Song = new GreenfootSound("wave4Music_Vivacity.mp3");
        wave4Song.setVolume(50);
        wave5Song = new GreenfootSound("wave5Music_Dont_Look_Down.mp3");
        wave5Song.setVolume(40);
        
        prepare();
    }
    
    /**
     * Act Method 
     */
    public void act() 
    {
        checkPauseGame();
        
        checkMusic();
    }
    
    /**
     * Prepare the world
     */
    public void prepare()
    {   
        /* World Background SETUP */
        PicnicBlanket picnicblanket = new PicnicBlanket();
        addObject(picnicblanket, 30, 495);

        Spawner spawner = new Spawner();
        addObject(spawner, 570, 115);

        TreeStump treestump = new TreeStump();
        addObject(treestump, 567, 159);
        treestump.setLocation(638, 126);

        AntHome anthome = new AntHome();
        addObject(anthome, 750, 210);        

        /* HUD SETUP */
        Spawnables spawnables = new Spawnables();
        addObject(spawnables, 400, 550);

        Scoreboard scoreboard = new Scoreboard();
        addObject(scoreboard, 600, 525);

        addObject(powerbar, 60, 565); // Add powerbar to world

        addObject(wave, 600, 575); // Initial Waves HUD
        //addObject(new TempWavesHUD(level), 580, 575);

        PowerScore powerscore = new PowerScore();
        addObject(powerscore, powerbar.getX() - 5, powerbar.getY() - 35);

        FacialExpression facialexpression = new FacialExpression();
        addObject(facialexpression, 400, 550);

        /* Adding all Scorestreak Icons to the HUD */
        MatchIcon matchicon = new MatchIcon();
        addObject(matchicon, 160, 576);

        CrusherIcon crushericon = new CrusherIcon();
        addObject(crushericon, 160, 532);

        BeamIcon beamicon = new BeamIcon();
        addObject(beamicon, 205, 532);

        GlueIcon glueicon = new GlueIcon();
        addObject(glueicon, 205, 576);

        BoltIcon bolticon = new BoltIcon();
        addObject(bolticon, 250, 532);

        FireCrackerIcon firecrackericon = new FireCrackerIcon();
        addObject(firecrackericon, 250, 576);

        TidalWaveIcon tidalwaveicon = new TidalWaveIcon();
        addObject(tidalwaveicon, 295, 532);

        
        /* Food SETUP */
        addObject(food, 107, 431); // Add food to world

        FoodCounter fc = new FoodCounter();
        addObject(fc, food.getX(), food.getY() + 50);

        // Makes sure that the pop-up for next wave is behind hudbar
        setPaintOrder(MiscButtons.class, Score.class, Powerbar.class, FoodCounter.class, Protagonist.class, WavesHUD.class, 
            AnimatedActor.class, Spawnables.class, TidalWaveOverlay.class, Enemy.class, Food.class, GluePile.class, TempWavesHUD.class, setting.class); 
    }
    
    /**
     * Check to see if the game should be paused
     */
    public void checkPauseGame()
    {
        if (Greenfoot.isKeyDown("escape") && getObjects(PauseBackground.class).isEmpty()) {
            addObject(new PauseBackground(), 400, 300);
            addObject(play, 400, 300);
            isPaused = true;
        }
        else if (Greenfoot.mouseClicked(play)) {
            removeObject(play);
            removeObjects(getObjects(PauseBackground.class));
            isPaused = false;
        }
    }
    
    /**
     * Checks what music should be playing currently
     */
    public void checkMusic()
    {
        if (level == 1 && wave1Song.isPlaying() == false)
        {
            wave1Song.play();
        }
        else if (level == 2 && wave2Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 1
            stopMusic();
            
            wave2Song.play();
        }
        else if (level == 3 && wave3Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 2
            stopMusic();
            
            wave3Song.play();
        }
        else if (level == 4 && wave4Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 3
            stopMusic();
            
            wave4Song.play();
        }
        else if (level == 5 && wave5Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 4
            stopMusic();
            
            wave5Song.play();
        }
    }
    
    /**
     * Stop All Music
     */
    public void stopMusic()
    {
        if (wave1Song.isPlaying() == true)
        {
            wave1Song.stop();
        }
        if (wave2Song.isPlaying() == true)
        {
            wave2Song.stop();
        }
        if (wave3Song.isPlaying() == true)
        {
            wave3Song.stop();
        }
        if (wave4Song.isPlaying() == true)
        {
            wave4Song.stop();
        }
        if (wave5Song.isPlaying() == true)
        {
            wave5Song.stop();
        }
    }
    
    /**
     * Returns the current level of the world -- Used for spawn rate
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * Advances the level
     */
    public void nextLevel() {
        // Checks whether or not the level can be changed. Prevents double stacking level increases
        if (level * level * levelThreshold <= score) {
            level++;
            if (level == 6) {
                
            }
            else {
                int x = wave.getX();
                int y = wave.getY();
                removeObject(wave);
                wave = new WavesHUD(level);
                
                addObject(wave, x, y);
                addObject(new TempWavesHUD(level), x, y);
            }
        }
    }
    
    public void endGame() { 
        stopMusic(); 
        Greenfoot.setWorld(new EndGameScreen(level, score));
    }
    
    public void powerDone() {
        powerbar.freeToUse();
    }
}
