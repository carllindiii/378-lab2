import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class OpeningScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningScreen extends World
{
    PlayButton play = new PlayButton(1);
    TutorialButton tut = new TutorialButton();
    
    public GreenfootImage titleScreen;
    /**
     * Constructor for objects of class OpeningScreen.
     * 
     */
    public OpeningScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        titleScreen = new GreenfootImage("TitleScreen.png");
        
        prepare();
    }
    
    public void prepare() {
        setBackground(titleScreen);
        
        // Add in buttons: Play/Tutorial/Credits
        addObject(play, 400, 400);
        addObject(tut, 400, 500);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(play)) {
            Greenfoot.setWorld(new setting());
        }
        
        if (Greenfoot.mouseClicked(tut)) {
            Greenfoot.setWorld(new TutorialScreen());
        }
    }
}
