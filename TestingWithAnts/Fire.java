import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends AnimatedActor
{
    public Fire()
    {
        super("flame", ".png", 6);
        
        // scale the fire
        for(GreenfootImage image : images) {
            image.scale(image.getWidth() - 300, image.getHeight() - 300);
        }
    }
    
    public void act() {
        super.act();  // this takes care of the image animation     
    }    
}
