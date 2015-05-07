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
   
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        if (Greenfoot.getRandomNumber(spawnRange) < (spawnThreshold /* * w.level*/))
        {
            w.addObject(new Ant(), getX(), getY());
        }
        
        if (w.score > w.level * w.level * w.levelThreshold) {
            w.nextLevel();
        }
    }    
}
