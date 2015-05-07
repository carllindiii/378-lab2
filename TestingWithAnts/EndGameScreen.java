import greenfoot.*;

/**
 * Write a description of class EndGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameScreen extends World
{

    /**
     * Constructor for objects of class EndGameScreen.
     * 
     */
    public EndGameScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    
    public void prepare() {
        addObject(new PlayButton(), 400, 300);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            Greenfoot.setWorld(new setting());
        }
    }
}
