package Entities;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.awt.*;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Entities.MainCharacter;


/**
 *  Abstract class for all the enemies that the runner has to avoid
 *
 *  @author  Ritik Batra and Johnson Ku
 *  @version May 26, 2017
 *  @author  Period: 2
 *  @author  Assignment: JavaRun
 *
 *  @author  Sources: none
 */
public abstract class Enemies
{
    private BufferedImage image;

    private double x;

    private double y;

    private double speed;

    private boolean onScreen;


    /**
     * Fills in the fields and reads in the image
     * @param s image location
     * @param x location
     * @param y location
     * @param spd speed
     */
    public Enemies( String s, int x, int y, double spd )
    {
        speed = spd;
        onScreen = true;
        try
        {
            image = ImageIO.read( getClass().getResourceAsStream( s ) );
            this.x = x;
            this.y = y;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }


    /**
     * Updates the position of the enemy
     */
    public abstract void update();

    /**
     * Changes onScreen to false
     */
    public void offScreen()
    {
        onScreen = false;
    }

    /**
     * Gets the speed of the enemy
     * @return speed
     */
    public double speed()
    {
        return speed;
    }
    
    /**
     * Sets enemy speed to given number
     * @param num speed
     */
    public void setSpeed( double num )
    {
        speed = num;
    }
    /**
     * Sets x to given number
     * @param num x
     */
    public void setX( double num )
    {
        x = num;
    }
    /**
     * Sets y to given number
     * @param num y 
     */
    public void setY(double num)
    {
        y = num;
    }
    
    /**
     * Gets x
     * @return x
     */
    public double getX()
    {
        return x;
    }
    
    /**
     * Gets y
     * @return y
     */
    public double getY()
    {
        return y;
    }
    
    /**
     * Draws the enemy on the screen
     * @param g Graphics2D
     */
    public abstract void draw( Graphics2D g );
    
    /**
     * Gets the image of the enemy
     * @return image
     */
    public BufferedImage getImage()
    {
        return image;
    }
    
    /**
     * Checks if the enemy is on the screen
     * @return onScreen
     */
    public boolean exists()
    {
        return onScreen;
    }
    
    /**
     * Used to differentiate the types of enemies
     * @return string
     */
    public abstract String toString();

}
