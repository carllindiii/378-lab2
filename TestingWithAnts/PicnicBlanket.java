import greenfoot.*;

/**
 * Write a description of class PicnicBlanket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PicnicBlanket extends Background
{
    /**
     * Constructor for the picnic blanket (mainly for re-sizing)
     */
    public PicnicBlanket()
    {
        GreenfootImage pb = new GreenfootImage("picnic_blanket.png");
        
        pb.scale(pb.getWidth() - 150, pb.getHeight() - 150);
        
        setImage(pb);
    }
    
    /**
     * Act - do whatever the PicnicBlanket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
