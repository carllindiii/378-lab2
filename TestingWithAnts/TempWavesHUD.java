import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TempWavesHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempWavesHUD extends Background
{
    GreenfootImage text;
    private int delay = 100;
    private int delayCounter = 0;
    private boolean exitting = false;
    
    private static final int Y_PLACEMENT = 480;
    
    public TempWavesHUD(int level) {
        if (level <= 5) {
            text = new GreenfootImage("NextWaveText.png");
            //text = new GreenfootImage("FreePlay.png");
            setImage(text);
        }
        else {
            text = new GreenfootImage("FreePlay.png");
            setImage(text);
        }
    }
    
    /**
     * Wave advancement is announced, drops down from top to middle of screen.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        if (exitting == false) {
            if (getY() <= Y_PLACEMENT) {
                delayCounter++;
            }
            else {
                setLocation(getX(), getY() - 3);
            }
        }
        
        if (delayCounter == delay || exitting) {
            exitting = true;
            setLocation(getX(), getY() + 3);
            if (getY() >= 525) {
                switch (w.level) {
                    case 3:
                        w.addObject(new FastAntWave(1), getX(), Y_PLACEMENT);
                        break;
                    case 4:
                        w.addObject(new FastAntWave(2), getX(), Y_PLACEMENT);
                        break;
                    case 5:
                        w.addObject(new FastAntWave(3), getX(), Y_PLACEMENT);
                        break;
                }
                w.removeObject(this);
             }
        }
    }    
}
