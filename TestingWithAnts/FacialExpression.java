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
    // Total number of images
    public static final int IMG_COUNT = 9;
    
    // Thresholds Levels between each facial expression change
    public static final int LEVEL1 = 30; // Happy-to-Neutral Threshold
    public static final int LEVEL2 = 25; // Neutral-to-Worried 
    public static final int LEVEL3 = 20; // Worried-to-Sad 
    public static final int LEVEL4 = 15; // Sad-to-Frightened
    public static final int LEVEL5 = 10; // Frightened-to-Crying
    
    /* Defining Facial Expressions to ints for array indexing purposes */
    public static final int HAPPY = 0; // FULL FOOD
    public static final int NEUTRAL = 1; // MOST FOOD
    public static final int WORRIED = 2; // SOME FOOD
    public static final int SAD = 3; // LOW FOOD
    public static final int FRIGHTENED = 4; // VERY LOW FOOD
    public static final int CRYING = 5; // EXTREMELY LOW FOOD
    public static final int BLINK1 = 6; // BLINK VARIATION 1
    public static final int BLINK2 = 7; // BLINK VARIATION 2
    public static final int SATISFIED = 8; // SCORESTREAK EXPRESSION 1
    
    /** 
     * ALL Facial Expression Images
     */
    // Array of facial expressions
    public GreenfootImage[] faces;
    
    /**
     * Variables that we need to keep track of throughout this class
     */
    // Character's moods
    public int lastMood; // very last mood
    public int mood; // current mood
    
    /**
     * Constructor to initialize all variables
     */
    public FacialExpression()
    {
        faces = new GreenfootImage[IMG_COUNT];
        
        // Initializing the Food Remaining Hierarchy Faces
        faces[HAPPY] = new GreenfootImage("Face0_happy.png"); // Full food
        faces[NEUTRAL] = new GreenfootImage("Face1_neutral.png"); // Most food
        faces[WORRIED] = new GreenfootImage("Face2_worried.png"); // Some food
        faces[SAD] = new GreenfootImage("Face3_sad.png"); // Low food
        faces[FRIGHTENED] = new GreenfootImage("Face4_frightened.png"); // Very low food
        faces[CRYING] = new GreenfootImage("Face5_crying.png"); // EXTREMELY low food
        
        // Blinking faces
        faces[BLINK1] = new GreenfootImage("Face_Blink.png");
        faces[BLINK2] = new GreenfootImage("Face_Blink2.png");
        
        // Scorestreak faces
        faces[SATISFIED] = new GreenfootImage("Face9_satisfied.png");
        
        setImage(faces[HAPPY]);
        
        // Initializing the character's expression
        lastMood = HAPPY;
        mood = HAPPY;
    }
    
    /**
     * Act - do whatever the FacialExpression wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setting w = (setting)getWorld();
        int foodLeft = w.food.getCount();
        
        // Figures out the current mood of the player based on the game's state
        checkMood();
        
        // The mood has changed, so we need to change the facial expression
        if (mood != lastMood)
        {
            if (mood == HAPPY)
            {
                // Change face to happy
                changeFaceTo(HAPPY);
                lastMood = HAPPY; // last mood was happy
            }
            else if (mood == NEUTRAL)
            {
                // Change face to neutral
                changeFaceTo(NEUTRAL);
                lastMood = NEUTRAL; // set the lastMood
            }
            else if (mood == WORRIED)
            {
                // Chance face to worried
                changeFaceTo(WORRIED);
                lastMood = WORRIED; // set the lastMood
            }
            else if (mood == SAD)
            {
                // Change face to sad
                changeFaceTo(SAD);
                lastMood = SAD; // set the lastMood
            }
            else if (mood == FRIGHTENED)
            {
                // Change face to frightened
                changeFaceTo(FRIGHTENED);
                lastMood = FRIGHTENED; // set the lastMood
            }
            else if (mood == CRYING)
            {
                // Change face to cry
                changeFaceTo(CRYING);
                lastMood = CRYING; // set the lastMood
            }
            else if (mood == SATISFIED)
            {
                // Change face to satisfied
                changeFaceTo(SATISFIED);
                lastMood = SATISFIED; // set the lastMood
            }
        }
        
    }
    

    /**
     * Figures out the mood of our character based on the game's state
     */
    public void checkMood()
    {
        setting w = (setting)getWorld();
        int foodLeft = w.food.getCount();
        
        if (w.powerbar.powerInUse == true) // Scorestreak being used
        {
            mood = SATISFIED;
        }
        else if (foodLeft >= LEVEL1) // Happy
        {
            mood = HAPPY;
        }
        else if (foodLeft < LEVEL1 && foodLeft >= LEVEL2) // Neutral
        {
            mood = NEUTRAL;
        }
        else if (foodLeft < LEVEL2 && foodLeft >= LEVEL3) // Worried
        {
            mood = WORRIED;
        }
        else if (foodLeft < LEVEL3 && foodLeft >= LEVEL4) // Sad
        {
            mood = SAD;
        }
        else if (foodLeft < LEVEL4 && foodLeft >= LEVEL5) // Frightened
        {
            mood = FRIGHTENED;
        }
        else // Crying
        {
            mood = CRYING;
        }
    }
    
    /**
     * Changes the facial expression to the provided parameter
     */
    public void changeFaceTo(int newFace)
    {
        setting w = (setting)getWorld();
        Blink blink;
        
        // If lastMood was frightened use BLINK2 otherwise use BLINK1
        if (lastMood == FRIGHTENED)
        {
            blink = new Blink(BLINK2);
        }
        else
        {
            blink = new Blink(BLINK1);
        }
        
        w.addObject(blink, this.getX(), this.getY());
        setImage(faces[newFace]);
    }
}
