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
    CreditButton credits = new CreditButton(); // CHANGE TO CREDITS BUTTON
    
    public GreenfootImage titleScreen;
    public GreenfootSound introSong;
    public boolean playSong;
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
        
        playSong = true;
        
        prepare();
    }
    
    
    /**
     * Special constructor to state whether or not the intro song should be played or not
     */
    public OpeningScreen(boolean ignoreSong, GreenfootSound songPlaying)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        titleScreen = new GreenfootImage("TitleScreen.png");
        introSong = songPlaying;
        
        playSong = ignoreSong;
        
        prepare();
    }
    
    public void prepare() {
        setBackground(titleScreen);
        
        // Add in buttons: Play/Tutorial/Credits
        addObject(play, 400, 400);
        addObject(tut, 400, 475);
        addObject(credits, 400, 550);
        
        if (playSong == true)
        {
            introSong.play();
            playSong = false;
        }
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(play)) {
            stopSong();
            Greenfoot.setWorld(new setting());
        }
        
        if (Greenfoot.mouseClicked(tut)) {
            //stopSong();
            Greenfoot.setWorld(new TutorialScreen(1, introSong));
        }
        
        if (Greenfoot.mouseClicked(credits)) {
            Greenfoot.setWorld(new CreditsWorld(introSong));
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
