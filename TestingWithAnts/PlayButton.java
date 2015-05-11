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
    GreenfootImage img;
    public PlayButton(int type) {
        switch (type) {
            case 1:
                //GreenfootImage text = new GreenfootImage("PLAY", 75, Color.BLACK, null);
                img = new GreenfootImage("Button_Play.png");
                setImage(img);
                break;
            case 2:
                img = new GreenfootImage("Button_PlayAgain.png");
                setImage(img);
                break;
            case 3:
                img = new GreenfootImage("Button_Back.png");
                setImage(img);
                break;
            case 4:
                img = new GreenfootImage("Button_FreePlay.png");
                setImage(img);
                break;
            case 5:
                img = new GreenfootImage("Button_Continue.png");
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
