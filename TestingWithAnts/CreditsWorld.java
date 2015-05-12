import greenfoot.*;

/**
 * Write a description of class CreditsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsWorld extends World
{
    PlayButton back = new PlayButton(3);
    /**
     * Constructor for objects of class CreditsWorld.
     * 
     */
    public CreditsWorld()
    { 
        super(800, 600, 1);
        prepare();
    }
    
    public void prepare() {
        addObject(back, 150, 50);
        addObject(new CreditsScroll(), 400, 600);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(back)) {
            Greenfoot.setWorld(new OpeningScreen());
        }
    }
}
