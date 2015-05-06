import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Spawnables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawnables extends Actor
{
    // All Scorestreak Costs as variables here
    public static final int CRUSHER_COST = 10;
    public static final int MATCH_COST = 25;
    public static final int BEAM_COST = 45;
    
    
    /**
     * Construct the Spawnables
     */
    public Spawnables()
    {
        setImage(new GreenfootImage("Bottom HUD.png"));
    }
    
    /**
     * Act - do whatever the Spawnables wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        setting w = (setting)getWorld();
        List<Powerbar> powerbarList = (List<Powerbar>) w.getObjects(Powerbar.class);
        Powerbar powerbar = powerbarList.get(0);
        
        final int totalPower = powerbar.getPower();

        // Press "1" for "Crusher" Scorestreak
        if (Greenfoot.isKeyDown("1") && totalPower >= CRUSHER_COST)
        {
            Crusher crush = new Crusher();
            getWorld().addObject(crush, mi.getX(), mi.getY());
            
            //TODO: Brian fix this so it only happens once!
            System.out.println("Used: Crusher");
            powerbar.removePower(CRUSHER_COST);
        }
        // Press "2" for "Match" Scorestreak
        else if (Greenfoot.isKeyDown("2") && totalPower >= MATCH_COST)
        {
            Match match = new Match();
            getWorld().addObject(match, mi.getX(), mi.getY());
            
            //TODO: Brian fix this so it only happens once!
            System.out.println("Used: Match");
            powerbar.removePower(MATCH_COST);
        }
        // Press "3" for "Beam" Scorestreak
        else if (Greenfoot.isKeyDown("3") && totalPower >= BEAM_COST)
        {
            Beamer beam = new Beamer();
            getWorld().addObject(beam, mi.getX(), mi.getY());
            
            //TODO: Brian fix this so it only happens once!
            System.out.println("Used: Beam");
            powerbar.removePower(BEAM_COST);
        }
        
        // CHEAT codes for testing purposes
        if(Greenfoot.isKeyDown("=")) 
        {
            //set max power
            powerbar.setPower(200);
        }
    }    
    
    /**
     * Spawnable actor follows the mouse
     */
    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        if (mi != null)
        {
            setLocation(mi.getX(), mi.getY());
        }
    }
}
