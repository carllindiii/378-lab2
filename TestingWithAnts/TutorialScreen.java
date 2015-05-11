import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TutorialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialScreen extends World
{
    private static final int MAX_SCREEN = 10;
    private int currentScreen; // The current slide the tutorial is on. Back is -1, Continue is +1
    
    PlayButton play = new PlayButton(1); // Play Button - skip to playing
    PlayButton back = new PlayButton(3); // Back Button - goes to previous tutorial screen (or main menu)
    PlayButton next = new PlayButton(5); // Continue button - goes to next tutorial screen
    
    /**
     * Constructor for objects of class TutorialScreen.
     * 
     */
    public TutorialScreen(int screenNumber) // screenNumber is the screen to set up.
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
  
        currentScreen = screenNumber;
        
        prepare();
    }
    
    public void prepare() {
        // Set the image of the background
        getBackground().drawImage(new GreenfootImage("Current Sreen: " + currentScreen, 20, Color.BLACK, null), 400, 300);
        
        // Add buttons
        if (currentScreen == MAX_SCREEN) {
            // Final screen before actual game, next button is now just play button.
            addObject(play, 650, 525);
        }
        else {
            addObject(play, 650, 75);
            addObject(next, 650, 525);
        }
        addObject(back, 150, 525);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(play)) {
            Greenfoot.setWorld(new setting());
        }
        else if (Greenfoot.mouseClicked(next) && currentScreen != MAX_SCREEN) {
            Greenfoot.setWorld(new TutorialScreen(currentScreen + 1));
        }
        else if (Greenfoot.mouseClicked(back)) {
            if (currentScreen == 1) {
                Greenfoot.setWorld(new OpeningScreen());
            }
            else {
                Greenfoot.setWorld(new TutorialScreen(currentScreen - 1));
            }
        }
    }
}
