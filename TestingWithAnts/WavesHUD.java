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
    
    public WavesHUD(int level) {
        image = new GreenfootImage("wave" + level + ".png");
        setImage(image);
    }
    
    /**
     * Act - do whatever the WavesHUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
