import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Spawnables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawnables extends Actor
{    
    static final int crushPower = 20;
    static final int matchPower = 40;
    
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

        if (Greenfoot.isKeyDown("1") && totalPower >= crushPower)
        {
            Crusher crush = new Crusher();
            getWorld().addObject(crush, mi.getX(), mi.getY());
            
            //TODO: Brian fix this so it only happens once!
            System.out.println("Used: crushPower");
            powerbar.removePower(crushPower);
        }
        else if (Greenfoot.isKeyDown("2") && totalPower >= matchPower)
        {
            Match match = new Match();
            getWorld().addObject(match, mi.getX(), mi.getY());
            
            //TODO: Brian fix this so it only happens once!
            System.out.println("Used: matchPower");
            powerbar.removePower(matchPower);
        }
        
        //cheat codes
        if(Greenfoot.isKeyDown("=")) {
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
