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
        setBackground(new GreenfootImage("TitleScreen.png"));
        
        PauseBackground background = new PauseBackground();
        addObject(background, 400, 300);
        
        CreditsScroll cred = new CreditsScroll();
        addObject(cred, 400, 400);
        
        addObject(back, 150, 50);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(back)) {
            Greenfoot.setWorld(new OpeningScreen());
        }
    }
}
