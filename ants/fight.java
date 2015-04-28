import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Write a description of class fight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fight extends Actor
{
   private final static int MAX_INTENSITY = 180;
    private int intensity;

    public fight()
    {
        intensity = MAX_INTENSITY;
        //updateImage();
    }


    public void act()
    {
        intensity -= 1;
        if (intensity <= 0) {
            getWorld().removeObject(this);
        }
        else {
            if ((intensity % 4) == 0) {
                //updateImage();
            }
        }
    }

    /**
     * Make the image
     */
    private void updateImage()
    {
        int size = intensity / 3 + 5;
        GreenfootImage image = new GreenfootImage(size + 1, size + 1);
        int alpha = intensity / 3;
        image.setColor(new Color(255, 255, 255, alpha));
        image.fillOval(0, 0, size, size);
        image.setColor(Color.RED);
        image.fillRect(size / 8, size / 8, 8, 8);
        setImage(image);
    }
}