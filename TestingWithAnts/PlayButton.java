import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends MiscButtons
{
    public PlayButton(int type) {
        switch (type) {
            case 1:
                //GreenfootImage text = new GreenfootImage("PLAY", 75, Color.BLACK, null);
                GreenfootImage playButton = new GreenfootImage("Button_Play.png");
                setImage(playButton);
                break;
            case 2:
                GreenfootImage img = new GreenfootImage("Button_PlayAgain.png");
                setImage(img);
                break;
        }
    }
    
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
