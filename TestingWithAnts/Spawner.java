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
    
    private final static int MIN_X = 600;
    private final static int RANDOM_X = 200;
    private final static int MIN_Y = 10;
    private final static int RANDOM_Y = 100;
    
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
        
        if (delay >= 50) {
            setLocation(MIN_X + Greenfoot.getRandomNumber(RANDOM_X), 
                        MIN_Y + Greenfoot.getRandomNumber(RANDOM_Y));
            delay = 0;
        }
        delay++;
        
        if (w.getObjects(Enemy.class).size() < maxAnts) {
            switch (w.level) {
                case 6:
                case 5:
                case 4:
                case 3:
                    if (Greenfoot.getRandomNumber(spawnRange) < (spawnThreshold/w.level))
                    {
                        w.addObject(new FastAnt(), getX(), getY());
                    }
                case 2:
                case 1:
                    if (Greenfoot.getRandomNumber(spawnRange) < (spawnThreshold))
                    {
                        w.addObject(new Ant(), getX(), getY());
                    }
                    break;
            }
        }
        if ((w.score > (w.level * w.level * w.levelThreshold)) && w.level <= 6) {
            w.nextLevel();
        }
    }    
}
