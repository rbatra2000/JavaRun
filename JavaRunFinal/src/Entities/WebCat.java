package Entities;

import java.awt.Graphics2D;


/**
 * An unpredictable jumping cat that strikes fear into the hearts of students.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 26, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class WebCat extends Enemies
{
    private double velocityY;

    private boolean onGround;

    private double gravity = 0.15f;


    /**
     * Initializes the variables.
     * 
     * @param s image location
     * @param x position
     * @param y position
     * @param spd speed
     */
    public WebCat( String s, int x, int y, double spd )
    {
        super( s, x, y, spd );
        onGround = true;
    }


    /**
     * Changes the x and y position of the webcat and updates the boolean when
     * it is off the screen. The method also deals with the physics of the
     * jumping, making the webcat just sporadically.
     */
    public void update()
    {
        setX( getX() - speed() );
        setY( getY() + velocityY );
        velocityY += gravity;
        if ( getX() < 0 )
        {
            offScreen();
        }
        if ( getY() > 160.0 )
        {
            setY( 160 );
            velocityY = 0.0;
            onGround = true;
        }
        if ( onGround )
        {
            velocityY = Math.random() * -8f;
            onGround = false;
        }
    }


    /**
     * Draws the webcat
     * @param g Graphics2D
     */
    public void draw( Graphics2D g )
    {
        g.drawImage( getImage(), (int)getX(), (int)getY(), 40, 20, null );
    }


    /**
     * The type of enemy
     * @return string
     */
    public String toString()
    {
        return "WebCat";
    }


    // For Testing Purposes only:

    public boolean ground()
    {
        return onGround;
    }


    public double getGravity()
    {
        return gravity;
    }


    public double getVelocityY()
    {
        return velocityY;
    }


    public void offGround()
    {
        onGround = false;
    }
}
