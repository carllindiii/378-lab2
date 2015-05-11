import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Wave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TidalWave extends AnimatedActor
{
    public static double DROWN_RATE = 50;
    
    public TidalWaveOverlay tidalWave;
    public TidalWave() {
        super("TidalWave", ".png", 1);
        
        /* Initialize and add the tidal wave image overlay into the world
        tidalWave = new TidalWaveOverlay(this);
        ((setting)getWorld()).addObject(tidalWave, this.getX(), this.getY()); */
        
        // Setting transparency of the wave. 0 for invisible
        for (GreenfootImage image : images) {
            image.setTransparency(10);
        }
    }
    
    /**
     * Act - do whatever the Wave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        // Percent chance to drown any intersecting ants
        if (Greenfoot.getRandomNumber(100) < DROWN_RATE) {
            drown();
        }
        
        // Wave moves across screen, removes when it  reaches the end
        setLocation(getX() + 2, getY());
        if(getX() >= 799) {
            //tidalWaveSound.stop();
            w.removeObject(this);
            w.powerDone();
        }
    }    
    
    /**
     * Kills ants intersecting with tidal wave
     */
    public void drown() {
        List enemies = getIntersectingObjects(Enemy.class);
        setting w = (setting)getWorld();
        
        w.score += enemies.size();
        w.removeObjects(enemies);
    }
    
    /*
    public void drown() {
        List enemies = getIntersectingObjects(Enemy.class);
        setting w = (setting)getWorld();
        
        // Loop through ants that are intersecting
        int totalEnemies = enemies.size();
        for (int i = 0; i < totalEnemies; i++) {
            // DROWN_RATE percent chance of killing ants when it intersects.
            if (Greenfoot.getRandomNumber(100) < DROWN_RATE) {
                w.score++;
                w.removeObject((Actor)enemies.get(i));
            }
        }
    }
    */
}
