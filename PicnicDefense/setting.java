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
    public boolean winGame;
    
    public int spawnThreshold = 1; // Used for freeplay spawn rate
    public static final int NEXT_SPAWN_INCREASE = 100; // Every X kills in freeplay will increase spawn.
    public int checkSpawnIncrease = NEXT_SPAWN_INCREASE; // Used to prevent mass spawn increase at a particular score.
    
    public static final int points_wave_2 = 75;
    public static final int points_wave_3 = 150;
    public static final int points_wave_4 = 300;
    public static final int points_wave_5 = 600;
    public static final int points_freeplay = 1500;
    public int wave_score;
    WavesProgression wave_progress;
    
    PlayButton play = new PlayButton(3);
    MenuButton menu = new MenuButton();
    public boolean isPaused;
    FoodCounter fc;
    
    /* All Music for each wave */
    public GreenfootSound wave1Song;
    public GreenfootSound wave2Song;
    public GreenfootSound wave3Song;
    public GreenfootSound wave4Song;
    public GreenfootSound wave5Song;
    public GreenfootSound winSong;
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
        wave_score = 0;
        food = new Food();
        powerbar = new Powerbar();
        level = 1;
        wave = new WavesHUD(level);
        isPaused = false;
        winGame = false;
        
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
        winSong = new GreenfootSound("Evening Melodrama_WinningScreen.mp3");
        winSong.setVolume(50);
        
        prepare();
    }
    
    /**
     * Act Method 
     */
    public void act() 
    {
        if (winGame == false) {
            checkPauseGame();
            checkMusic();
            checkWave();
        }
        else {
            // The game is currently in the Game Win Screen.
            winGameScreen();
        }
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
        addObject(scoreboard, 750, 570);
        
        wave_progress = new WavesProgression(points_wave_2);
        addObject(wave_progress, 600, 530);

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
        addObject(food, 120, 425); // Add food to world

        fc = new FoodCounter();
        addObject(fc, food.getX(), food.getY() + 60);

        // Makes sure that the pop-up for next wave is behind hudbar
        setPaintOrder(MiscButtons.class, WinningScreen.class, MiscButtons.class, Score.class, Powerbar.class, FoodCounter.class, Protagonist.class, WavesHUD.class, 
            AnimatedActor.class, Spawnables.class, TidalWaveOverlay.class, Enemy.class, Food.class, GluePile.class, WavesLogic.class, setting.class); 
    }
    
    /**
     * Check to see if the game should be paused
     */
    public void checkPauseGame()
    {
        if (Greenfoot.isKeyDown("escape") && getObjects(PauseBackground.class).isEmpty()) {
            addObject(new PauseBackground(), 400, 300);
            addObject(play, 400, 250);
            addObject(menu, 400, 350);
            
            isPaused = true;
        }
        else if (Greenfoot.mouseClicked(play)) {
            removeObject(play);
            removeObject(menu);
            removeObjects(getObjects(PauseBackground.class));
            isPaused = false;
        }
        else if (Greenfoot.mouseClicked(menu)) {
            removeObject(play);
            removeObject(menu);
            removeObjects(getObjects(PauseBackground.class));
            isPaused = false;
            
            // Stop Music when returning to main menu
            stopMusic();
            level = 0; // Makes sure that CheckMusic doesn't run again in background.
            Greenfoot.setWorld(new OpeningScreen());
        }
    }
    
    /**
     * Checks what music should be playing currently
     */
    public void checkMusic()
    {
        if (level == 1 && wave1Song.isPlaying() == false)
        {
            wave1Song.playLoop();
        }
        else if (level == 2 && wave2Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 1
            stopMusic();
            
            wave2Song.playLoop();
        }
        else if (level == 3 && wave3Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 2
            stopMusic();
            
            wave3Song.playLoop();
        }
        else if (level == 4 && wave4Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 3
            stopMusic();
            
            wave4Song.playLoop();
        }
        else if (level >= 5 && wave5Song.isPlaying() == false)
        {
            // stop the last song which should be from wave 4
            stopMusic();
            
            wave5Song.playLoop();
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
    
    public void checkWave() {
        switch (level) {
            case 1:
                if (wave_score >= points_wave_2) {
                    wave_score %= points_wave_2;
                    removeObject(wave_progress);
                    wave_progress = new WavesProgression(points_wave_3);
                    addObject(wave_progress, 600, 530);
                    nextLevel();
                }
                break;
            case 2:
                if (wave_score >= points_wave_3) {
                    wave_score %= points_wave_3;
                    removeObject(wave_progress);
                    wave_progress = new WavesProgression(points_wave_4);
                    addObject(wave_progress, 600, 530);
                    nextLevel();
                }
                break;
            case 3:
                if (wave_score >= points_wave_4) {
                    wave_score %= points_wave_4;
                    removeObject(wave_progress);
                    wave_progress = new WavesProgression(points_wave_5);
                    addObject(wave_progress, 600, 530);
                    nextLevel();
                }
                break;
            case 4:
                if (wave_score >= points_wave_5) {
                    wave_score %= points_wave_5;
                    removeObject(wave_progress);
                    wave_progress = new WavesProgression(points_freeplay);
                    addObject(wave_progress, 600, 530);
                    nextLevel();
                }
                break;
            case 5:
                if (wave_score >= points_freeplay) {
                    wave_score %= points_freeplay;
                    removeObject(wave_progress);
                    nextLevel();
                }
                break;
            case 6:
                if (wave_score == checkSpawnIncrease) {
                    spawnThreshold++;
                    checkSpawnIncrease += NEXT_SPAWN_INCREASE;
                }
                break;
        }
    }
    
    /**
     * Advances the level
     */
    public void nextLevel() {
        // Checks whether or not the level can be changed. Prevents double stacking level increases
        level++;
        if (level >= 6) {
            if (winGame == false)
                winGame();
        }
        else {
            int x = wave.getX();
            int y = wave.getY();
            removeObject(wave);
            wave = new WavesHUD(level);
            
            addObject(wave, x, y);
            addObject(new WavesLogic(level), x, y);
        }
    }
    
    public void winGame() {
        // Pause game, remove any ongoing powerups.
        isPaused = true;
        removeObjects(getObjects(Flame.class));
        removeObjects(getObjects(Bolt.class));
        removeObjects(getObjects(TidalWave.class));
        removeObjects(getObjects(Beam.class));
        removeObjects(getObjects(Spark.class));
        powerDone();
        
        // Display winning screen along with other buttons.
        WinningScreen win = new WinningScreen();
        addObject(win, 400, 300);
        
        play = new PlayButton(4);
        menu = new MenuButton();
        addObject(play, 650, 525);
        addObject(menu, 150, 525);
        stopMusic();
        winSong.play();
        
        winGame = true;
    }
    
    public void winGameScreen() {
        if (Greenfoot.mouseClicked(play)) {
            // Enter into freeplay mode.
            isPaused = false;
            winGame = false;
            
            removeObjects(getObjects(WinningScreen.class));
            removeObjects(getObjects(PlayButton.class));
            removeObjects(getObjects(MenuButton.class));
            removeObjects(getObjects(Food.class));
            removeObjects(getObjects(FoodCounter.class));
            removeObjects(getObjects(Enemy.class));
            
            food = new Food();
            fc = new FoodCounter();
            addObject(food, 120, 425); // Add food to world
            addObject(fc, food.getX(), food.getY() + 60);
            
            winSong.stop();
        }
        // Return to Main Menu
        if (Greenfoot.mouseClicked(menu)) {
            isPaused = false;
            winGame = false;
            
            removeObjects(getObjects(WinningScreen.class));
            removeObjects(getObjects(PlayButton.class));
            removeObjects(getObjects(MenuButton.class));
            
            winSong.stop();
            Greenfoot.setWorld(new OpeningScreen());
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
