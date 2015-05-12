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
    private static final int MAX_SCREEN = 8;
    private int currentScreen; // The current slide the tutorial is on. Back is -1, Continue is +1
    
    PlayButton play = new PlayButton(1); // Play Button - skip to playing
    PlayButton back = new PlayButton(3); // Back Button - goes to previous tutorial screen (or main menu)
    PlayButton next = new PlayButton(5); // Continue button - goes to next tutorial screen
    
    GreenfootSound introSong;
    
    /**
     * Constructor for objects of class TutorialScreen.
     * 
     */
    public TutorialScreen(int screenNumber, GreenfootSound song) // screenNumber is the screen to set up.
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
  
        currentScreen = screenNumber;
        introSong = song;
        
        prepare();
    }
    
    public void prepare() {
        // Set the image of the background
        GreenfootImage img = new GreenfootImage("TutorialPg"+currentScreen+".png");
        getBackground().drawImage(img, 0, 0);
        
        // Add buttons
        if (currentScreen == MAX_SCREEN) {
            // Final screen before actual game, next button is now just play button.
            addObject(play, 670, 50);
        }
        else {
            addObject(next, 670, 50);
        }
        addObject(back, 130, 50);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(play)) {
            introSong.stop();
            Greenfoot.setWorld(new setting());
        }
        else if (Greenfoot.mouseClicked(next) && currentScreen != MAX_SCREEN) {
            Greenfoot.setWorld(new TutorialScreen(currentScreen + 1, introSong));
        }
        else if (Greenfoot.mouseClicked(back)) {
            if (currentScreen == 1) {
                Greenfoot.setWorld(new OpeningScreen());
            }
            else {
                Greenfoot.setWorld(new TutorialScreen(currentScreen - 1, introSong));
            }
        }
    }
}
