package Entities;

import java.awt.*;


/**
 * Abstract class for the different types of power ups
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 26, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public abstract class PowerUps
{

    /**
     * Draws the power up
     * 
     * @param g
     *            Graphics2D
     */
    public abstract void draw( Graphics2D g );


    /**
     * Updates the position of the objects
     */
    public abstract void update();


    /**
     * Sets the speed of the power up
     * 
     * @param a
     *            change in x
     * @param b
     *            change in y
     */
    public abstract void setVector( double a, double b );


    /**
     * Checks if the power up is on the screen
     * 
     * @return power up exists
     */
    public abstract boolean exists();

}
