import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TempWavesHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WavesLogic extends Background
{
    GreenfootImage text;
    private int delay = 100;
    private int delayCounter = 0;
    private boolean exitting = false;
    private int currLevel;
    private int transparency = 255;
    
    private static final int Y_PLACEMENT = 480;
    
    public WavesLogic(int level) {
        currLevel = level;
        if (level <= 4) {
            text = new GreenfootImage("NextWaveText.png");
            //text = new GreenfootImage("FreePlay.png");
            setImage(text);
        }
        else if (level == 5) {
            // Final wave logic
            text = new GreenfootImage("FinalWaveText.png");
            setImage(text);
        }
    }
    
    /**
     * Wave advancement is announced
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (currLevel <= 4) {
            // Display next wave at bottom right corner.
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
                            w.addObject(new AntWaveIndicator(1), getX(), Y_PLACEMENT);
                            break;
                        case 4:
                            w.addObject(new AntWaveIndicator(2), getX(), Y_PLACEMENT);
                            break;
                        case 5:
                            w.addObject(new AntWaveIndicator(3), getX(), Y_PLACEMENT);
                            break;
                    }
                    w.removeObject(this);
                 }
            }
        }
        else if (currLevel == 5) {
            // Final wave actions
            setLocation(400, 300);
            if (delayCounter == 8) {
                transparency -= 10;
                if (transparency <= 0) {
                    w.removeObject(this);
                }
                else {
                    text.setTransparency(transparency);
                }
                delayCounter = 0;
            }
            delayCounter++;
        }
    }    
}
