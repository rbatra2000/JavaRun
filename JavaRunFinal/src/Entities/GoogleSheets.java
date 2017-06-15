package Entities;

import java.awt.Graphics2D;

import Main.GamePanel;


/**
 * Stationary obstacle that extends enemies. The google sheets-feared for the
 * mind boggling multiple choice.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 26, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class GoogleSheets extends Enemies
{
    /**
     * Calls super constructor for enemies
     * @param s image location
     * @param x position
     * @param y position 
     * @param spd speed
     */
    public GoogleSheets( String s, int x, int y, double spd )
    {
        super( s, x, y, spd );
    }


    /**
     * Updates position and checks if the object is on the screen
     */
    public void update()
    {
        setX( getX() - speed() );
        if ( getX() < 0 )
        {
            offScreen();
        }
    }


    /**
     * Draws the image with dimensions 30 by 30.
     * @param g Graphics2D
     */
    public void draw( Graphics2D g )
    {
        g.drawImage( getImage(), (int)getX(), (int)getY(), 30, 30, null );
    }


    /**
     * Returns the type of object it is.
     * @return string
     */
    public String toString()
    {
        return "GoogleSheets";
    }
}
