import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class EndGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameScreen extends World
{
    PlayButton playAgain = new PlayButton(2);
    MenuButton menu = new MenuButton();
    public int finalScore;
    
    /**
     * Constructor for objects of class EndGameScreen.
     * 
     */
    public EndGameScreen(int level, int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        finalScore = score;
        prepare();
    }
    
    public void prepare() {
        GreenfootImage img = new GreenfootImage("GameOverScreen.png");
        setBackground(img);
        
        // Display Wave/Score
        // Pressable Buttons: Credits, Main Menu, Play Again
        addObject(playAgain, 693, 400);
        addObject(menu, 693, 475);
        
        GreenfootImage scoreboard = new GreenfootImage("Final Score: " + finalScore, 50, Color.BLACK, null);
        getBackground().drawImage(scoreboard, 200, 135);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(playAgain)) {
            Greenfoot.setWorld(new setting());
        }
        if (Greenfoot.mouseClicked(menu)) {
            Greenfoot.setWorld(new OpeningScreen());
        }
    }
}
