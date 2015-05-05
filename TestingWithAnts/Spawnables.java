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
        
        if (Greenfoot.isKeyDown("1") && totalPower >= crushPower) {
            Crusher crush = new Crusher();          
            getWorld().addObject(crush, mi.getX(), mi.getY());
        }
    }    
}
