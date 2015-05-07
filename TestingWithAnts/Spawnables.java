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
    public static final int BOLT_COST = 70;
    public Powerbar powerbar;
    public int delay; // Short delay to prevent accidental spamming.
    
    /**
     * Construct the Spawnables
     */
    public Spawnables()
    {
        setImage(new GreenfootImage("Bottom HUD.png"));
        delay = 0;
    }
    
    /**     
     * Act - do whatever the Spawnables wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        setting w = (setting)getWorld();

        powerbar = w.powerbar; // assign to state variable 'powerbar' in setting
        final int totalPower = powerbar.getPower();
        
        if (powerbar.usePower() == true && delay >= 40) {
            // Press "1" for "Crusher" Scorestreak
            if (Greenfoot.isKeyDown("1") && totalPower >= CRUSHER_COST)
            {
                Crusher crush = new Crusher();
                getWorld().addObject(crush, mi.getX(), mi.getY());
                
                powerbar.removePower(CRUSHER_COST);
                powerbar.inUse();
                delay = 0;
            }
            // Press "2" for "Match" Scorestreak
            else if (Greenfoot.isKeyDown("2") && totalPower >= MATCH_COST)
            {
                Match match = new Match();
                getWorld().addObject(match, mi.getX(), mi.getY());
                
                powerbar.removePower(MATCH_COST);
                powerbar.inUse();
                delay = 0;
            }
            // Press "3" for "Beam" Scorestreak
            else if (Greenfoot.isKeyDown("3") && totalPower >= BEAM_COST)
            {
                Beamer beam = new Beamer();
                getWorld().addObject(beam, mi.getX(), mi.getY());
                
                powerbar.removePower(BEAM_COST);
                powerbar.inUse();
                delay = 0;
            }
            // Press "4" for "Bolt Strike" Scorestreak
            else if (Greenfoot.isKeyDown("4") && totalPower >= BOLT_COST)
            {
                Lightning lightning = new Lightning();
                getWorld().addObject(lightning, mi.getX(), mi.getY());
                
                powerbar.removePower(BOLT_COST);
                powerbar.inUse();
                delay = 0;
            }
        }
        // CHEAT codes for testing purposes
        if(Greenfoot.isKeyDown("=")) 
        {
            //set max power
            powerbar.setPower(200);
        }
        
        delay++;
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
    
    public void removeSpawnable() 
    {
        setting w = (setting)getWorld();
        w.removeObject(this);
        
        powerbar = w.powerbar;
        powerbar.freeToUse();
    }
}
