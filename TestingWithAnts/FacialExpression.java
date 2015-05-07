import greenfoot.*;

/**
 * Write a description of class FacialExpression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FacialExpression extends Protagonist
{
    /**
     * Animation is not cyclical therefore must be HARDCODED
     */
    
    // Thresholds Levels between each facial expression change
    public static final int LEVEL1 = 30; // Happy-to-Neutral Threshold
    public static final int LEVEL2 = 25; // Neutral-to-Worried 
    public static final int LEVEL3 = 20; // Worried-to-Sad 
    public static final int LEVEL4 = 15; // Sad-to-Frightened
    public static final int LEVEL5 = 10; // Frightened-to-Crying
    
    /** 
     * ALL Facial Expression Images
     */
    // Hierarchy of Food Remaining
    public GreenfootImage happy; // FULL FOOD
    public GreenfootImage neutral; // MOST FOOD
    public GreenfootImage worried; // SOME FOOD
    public GreenfootImage sad; // LOW FOOD
    public GreenfootImage frightened; // VERY LOW FOOD
    public GreenfootImage crying; // EXTREMELY LOW FOOD
    
    // Transitioning Blinks
    public GreenfootImage blink1; // FIRST Variation
    public GreenfootImage blink2; // SECOND Variation (used in very low -> extremely low)
    
    // SCORESTREAK Facial Expressions
    public GreenfootImage satisfied; // FOR SCORESTREAKS
    
    
    /**
     * Constructor to initialize all variables
     */
    public FacialExpression()
    {
        // Initializing the Food Remaining Hierarchy Faces
        happy = new GreenfootImage("Face0_happy.png"); // Full food
        neutral = new GreenfootImage("Face1_neutral.png"); // Most food
        worried = new GreenfootImage("Face2_worried.png"); // Some food
        sad = new GreenfootImage("Face3_sad.png"); // Low food
        frightened = new GreenfootImage("Face4_frightened.png"); // Very low food
        crying = new GreenfootImage("Face5_crying.png"); // EXTREMELY low food
        
        // Blinking faces
        blink1 = new GreenfootImage("Face_Blink.png");
        blink2 = new GreenfootImage("Face_Blink2.png");
        
        // Scorestreak faces
        satisfied = new GreenfootImage("Face9_satisfied.png");
        
        setImage(happy);
    }
    
    /**
     * Act - do whatever the FacialExpression wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setting w = (setting)getWorld();
        int foodLeft = w.food.getCount();
        
        
        if (foodLeft >= LEVEL1) // Happy
        {
            changeFaceTo(happy);
        }
        else if (foodLeft < LEVEL1 && foodLeft >= LEVEL2) // Neutral
        {
            changeFaceTo(neutral);
        }
        else if (foodLeft < LEVEL2 && foodLeft >= LEVEL3) // Worried
        {
            changeFaceTo(worried);
        }
        else if (foodLeft < LEVEL3 && foodLeft >= LEVEL4) // Sad
        {
            changeFaceTo(sad);
        }
        else if (foodLeft < LEVEL4 && foodLeft >= LEVEL5) // Frightened
        {
            changeFaceTo(frightened);
        }
        else // Crying
        {
            changeFaceTo(crying);
        }
    }
    
    public void changeFaceTo(GreenfootImage nextFace)
    {
        setImage(nextFace);
    }
}
