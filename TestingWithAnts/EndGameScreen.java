import greenfoot.*;

/**
 * Write a description of class EndGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameScreen extends World
{
    PlayButton playAgain = new PlayButton();
    
    /**
     * Constructor for objects of class EndGameScreen.
     * 
     */
    public EndGameScreen(int level, int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    
    public void prepare() {
        // Display Wave/Score
        
        // Pressable Buttons: Credits, Main Menu, Play Again
        addObject(playAgain, 400, 300);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(playAgain)) {
            Greenfoot.setWorld(new setting());
        }
    }
}
