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
    public GreenfootSound introSong;
    /**
     * Constructor for objects of class OpeningScreen.
     * 
     */
    public OpeningScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        titleScreen = new GreenfootImage("TitleScreen.png");
        introSong = new GreenfootSound("MainMenuMusic_Overcast.mp3");
        introSong.setVolume(50);
        
        prepare();
    }
    
    public void prepare() {
        setBackground(titleScreen);
        
        // Add in buttons: Play/Tutorial/Credits
        addObject(play, 400, 400);
        addObject(tut, 400, 500);
        
        introSong.playLoop();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(play)) {
            stopSong();
            Greenfoot.setWorld(new setting());
        }
        
        if (Greenfoot.mouseClicked(tut)) {
            stopSong();
            Greenfoot.setWorld(new TutorialScreen(1));
        }
    }
    
    /**
     * Stops the song if it's currently playing
     */
    public void stopSong()
    {
        if (introSong.isPlaying() == true)
        {
            introSong.stop();
        }
    }
}
