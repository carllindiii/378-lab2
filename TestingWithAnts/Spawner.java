import greenfoot.*;

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    public static int spawnThreshold = 80;
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
        image.setTransparency(100);
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
                    case 5:
                        if (Greenfoot.getRandomNumber(spawnRange) < ((spawnThreshold/w.level)/3))
                        {
                            w.addObject(new NinjaAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                    case 4:
                        if (Greenfoot.getRandomNumber(spawnRange) < ((spawnThreshold/w.level)/2))
                        {
                            w.addObject(new StealthAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                    case 3:
                        if (Greenfoot.getRandomNumber(spawnRange) < (spawnThreshold/w.level))
                        {
                            w.addObject(new FastAnt(), getX() + Greenfoot.getRandomNumber(50) - 25,
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                    case 2:
                    case 1:
                        if (Greenfoot.getRandomNumber(spawnRange) < (spawnThreshold))
                        {
                            w.addObject(new Ant(), getX() + Greenfoot.getRandomNumber(50) - 25, 
                                        getY() + Greenfoot.getRandomNumber(50) - 25);
                        }
                        break;
                }
            }
            if ((w.score > (w.level * w.level * w.levelThreshold)) && w.level <= 5) {
                w.nextLevel();
            }
        }
    }    
}
