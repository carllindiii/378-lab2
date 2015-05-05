import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerbar extends AnimatedActor
{
    protected int powerCount;
    private int currentScore;
    
    public Powerbar()
    {
        super("powerbar", ".png", 11);
        powerCount = 0;
    }
    
    public void act() {
        setting w = (setting) getWorld();
        if(currentScore < w.score) {
            System.out.println("powerCount: " + powerCount + "\n" +
                               "currentScore: " + currentScore + "\n" +  
                               "w.score: " + w.score + "\n");
            powerCount += w.score - currentScore;
            currentScore = w.score;
        }
        chooseImage(powerCount);
    }   
    
    public void chooseImage(int count) {
        currentImage = count / 20;
        if(currentImage > 10) {
            currentImage = 10;
        }
        setImage(images[currentImage]);   
    }
    
    public void removePower(int power) {
        powerCount -= power;     
        if(powerCount < 0) {
            powerCount = 0;
        }
    }
    
    public int getPower() {
        return powerCount;
    }
}
