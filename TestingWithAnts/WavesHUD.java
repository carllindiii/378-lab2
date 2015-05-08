import greenfoot.*;

/**
 * Write a description of class WavesHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WavesHUD extends Background
{
    GreenfootImage image;
    private int lvl; // Thinking about adding freeplay animations later
    private int freeplay;
    
    public WavesHUD(int level) {
        if (level <= 5) {
            image = new GreenfootImage("wave" + level + ".png");
            setImage(image);
        }
        else {
            setImage(new GreenfootImage("wave5.png"));
        }
    }
    
    /**
     * Act - do whatever the WavesHUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
}
