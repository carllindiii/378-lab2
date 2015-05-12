import greenfoot.*;

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor  
{
    // Values used to determine spawn rate of ants at each wave level.
    // Regular ants
    private final static int WAVE_1_REG = 60;
    private final static int WAVE_2_REG = 60;
    private final static int WAVE_3_REG = 60;
    private final static int WAVE_4_REG = 60;
    private final static int WAVE_5_REG = 60;
    // Fast Ants
    private final static int WAVE_3_FAST = 60;
    private final static int WAVE_4_FAST = 60;
    private final static int WAVE_5_FAST = 60;
    // Stealth ants
    private final static int WAVE_4_STEALTH = 60;
    private final static int WAVE_5_STEALTH = 60;
    // Ninja ants
    private final static int WAVE_5_NINJA = 60;
    
    // Spawner logic stuff
    public static int spawnRange = 1000;
    public static int fastAntThreshold = 40;
    public final static int maxAnts = 200;
    
    private final static int MIN_X = 550;
    private final static int RANDOM_X = 200;
    private final static int MIN_Y = 50;
    private final static int RANDOM_Y = 50;
    
    private int delay;
    private final static int DELAY_MOVEMENT = 50;
   
    public Spawner() {
        GreenfootImage image = new GreenfootImage("apple1.png");
        setImage(image);
        image.setTransparency(0);
        delay = 0;
    }
    
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        if (w.isPaused == false) {
            if (delay >= 50) {
                setLocation(MIN_X + Greenfoot.getRandomNumber(RANDOM_X), 
                            MIN_Y + Greenfoot.getRandomNumber(RANDOM_Y));
                delay = 0;
            }
            delay++;
            
            if (w.getObjects(Enemy.class).size() < maxAnts) {
                switch (w.level) {
                    case 6:
                        // Freeplay
                        if (Greenfoot.getRandomNumber(spawnRange) < (WAVE_5_NINJA + w.spawnThreshold))
                        {
                            w.addObject(new NinjaAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < (WAVE_5_STEALTH + w.spawnThreshold))
                        {
                            w.addObject(new StealthAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < (WAVE_5_FAST + w.spawnThreshold))
                        {
                            w.addObject(new FastAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < (WAVE_5_REG + w.spawnThreshold))
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                    case 5:
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_5_NINJA)
                        {
                            w.addObject(new NinjaAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_5_STEALTH)
                        {
                            w.addObject(new StealthAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_5_FAST)
                        {
                            w.addObject(new FastAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_5_REG)
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                    case 4:
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_4_STEALTH)
                        {
                            w.addObject(new StealthAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_4_FAST)
                        {
                            w.addObject(new FastAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_4_REG)
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                    case 3:
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_3_FAST)
                        {
                            w.addObject(new FastAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_3_REG)
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                    case 2:
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_2_REG)
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                    case 1:
                        if (Greenfoot.getRandomNumber(spawnRange) < WAVE_1_REG)
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                }
            }
        }
    }    
}
