import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerbar extends AnimatedActor
{
    protected int powerCount;
    private int currentScore; 
    public boolean powerInUse;
    
    /**
     * Powerbar constructor
     */
    public Powerbar()
    {
        super("Power", ".png", 11);
        powerCount = 0;
        powerInUse = false;
    }
    
    /**
     * Fly to the left. When we hit the edge, disappear.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if(currentScore < w.score) 
        {
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
    
    public void setPower(int newPowerCount) {
        powerCount = newPowerCount;
    }
    
    public boolean usePower() {
        if (powerInUse == false)
            return true;
        else return false;
    }
    
    public void inUse() {
        powerInUse = true;
    }
    
    public void freeToUse() {
        powerInUse = false;
    }
}
