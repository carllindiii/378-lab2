import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Beam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beam extends AnimatedActor
{
    public static final int BEAM_TIME_LIMIT = 270;
    public static final int ALTERNATE = 4;
    
    public GreenfootSound beamSound;
    public int beamTime;
    /**
     * Beam Constructor
     */
    public Beam()
    {
        super("beam", ".png", 4);
        beamTime = BEAM_TIME_LIMIT;
        
        beamSound = new GreenfootSound("tractorBeam.mp3");
    }
    
    /**
     * Act - do whatever the Beam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (beamTime <= 0)
        {
            beamSound.stop(); // Stop the sound effect
            w.removeObject(this);
        }
        else
        {
            // Play beamSound if it's not being played (should repeat)
            if (beamSound.isPlaying() == false)
            {
                beamSound.play();
            }
            
            // animate the beam every ALTERNATE cycles
            if (beamTime % ALTERNATE == 0)
            {
                super.act();
            }
            
            lightUp(); // light up all enemies in the beam
            beamTime--;
        }
    }    
    
    /**
     * Lights up all enemies that intersect with the beam and remove them
     */
    public void lightUp()
    {
        List enemies = getIntersectingObjects(Enemy.class);
        setting w = (setting)getWorld();
        
        w.score += enemies.size();
        w.wave_score += enemies.size();
        w.removeObjects(enemies);
    }
}
