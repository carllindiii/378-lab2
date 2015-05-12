import greenfoot.*;
import java.util.List;

/**
 * Write a description of class GluePile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GluePile extends Glue
{
    public static final int GLUE_TIME_LIMIT = 450; // How long the glue pile will last
    public static final int DISSIPATE = 100; // Threshold to start fading the image away
    public static final int MOD_AGAINST_THIS = 5; // allowed to move once per this many cycles
    
    public int glueTime; // How long the glue has been active
    public GreenfootImage glueImg;
    /**
     * Constructor for the Pile of Glue
     */
    public GluePile()
    {
        glueTime = GLUE_TIME_LIMIT;
        glueImg = new GreenfootImage("SpilledGlue0.png");
        
        setImage(glueImg);
    }
    
    /**
     * Act - do whatever the GluePile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        
        if (glueTime > 0)
        {
            slowDown();
            
            // Slowly fade the image away
            if (glueTime < DISSIPATE)
            {
                int fade = (int)((DISSIPATE - glueTime) * 2.5); // round off to the nearest int
                glueImg.setTransparency(255 - fade);
                setImage(glueImg);
            }
            
            glueTime--;
        }
        else
        {
            w.removeObject(this);
        }
    }    
    
    /**
     * Grabs the enemies if they have been in the glue pile for a CERTAIN AMOUNT OF TIME
     */
    public void slowDown()
    {
        List<Ant> ants = getIntersectingObjects(Ant.class);
        for (Ant ant : ants)
        {
            // 50% chance of allowing the ant to move if the modulo result is 0
            if (glueTime % MOD_AGAINST_THIS == 0 && Greenfoot.getRandomNumber(100) < 50)
            {
                ant.canMove = true;
            }
            /* Allows ants to move every time the modulo result is 1
             * Also GUARANTEES ants can move after glue pile disappears */
            else if (glueTime % MOD_AGAINST_THIS == 1)
            {
                ant.canMove = true;
            }
            // Otherwise stop movement for this cycle
            else
            {
                ant.canMove = false;
            }
        }
    }
}
