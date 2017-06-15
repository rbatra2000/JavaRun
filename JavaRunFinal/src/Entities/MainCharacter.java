package Entities;

import java.awt.event.KeyEvent;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * This class determines the properties of the runner and controls the movement
 * of the runner. The runner will jump when the space key is pressed.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 26, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class MainCharacter
{

    private BufferedImage image;

    public double x;

    public double y;

    private double velocityX, velocityY; // Velocity of the character

    private double gravity = 0.5f; // How strong is gravity

    private boolean onGround;

    private int animation;

    private double count;

    public boolean jumped;

    private double time = 1;


    /**
     * Reads the image in and initializes the private fields
     * 
     * @param s image location
     * @param x position
     * @param y position
     */
    public MainCharacter( String s, int x, int y )
    {

        animation = 6;
        count = 0;
        jumped = false;
        onGround = false;
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
     * Sets the time to the given parameter
     * 
     * @param num
     *            time
     */
    public void setTime( double num )
    {
        time = num;
    }


    /**
     * Sets the x and y position of the character
     * 
     * @param x
     *            position
     * @param y
     *            position
     */
    public void setPosition( double x, double y )
    {
        this.x = x;
        this.y = y;
    }


    /**
     * Changes the speed of the legs
     * 
     * @param speed int
     */
    public void setAnimation( int speed )
    {
        animation = speed;
    }


    /**
     * Gets x position
     * 
     * @return x
     */
    public double getX()
    {
        return x;
    }


    /**
     * Gets y position
     * 
     * @return y
     */
    public double getY()
    {
        return y;
    }


    /**
     * Updates the position of the character. Changes the legs after a certain
     * amount of counts. Deals with the physics of the jump and changes the
     * boolean onGround based on where the character is.
     */
    public void update()
    {
        if ( onGround )
        {
            try
            {
                if ( count < animation )
                {
                    image = ImageIO.read( getClass().getResourceAsStream( "/Resources/Sprites/Player/running1.png" ) );
                }
                else if ( count >= animation )
                {
                    image = ImageIO.read( getClass().getResourceAsStream( "/Resources/Sprites/Player/standing.png" ) );
                }
                if ( count >= animation * 2 )
                {
                    count = 0;
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }
        y += velocityY * time; // Apply vertical velocity to Y position
        velocityY += gravity * time; // Apply gravity to vertical velocity

        if ( y > 160.0 )
        {
            y = 160;
            velocityY = 0;
            onGround = true;
        }

        // System.out.println(count);

        if ( onGround )
        {
            count++;
        }
        // System.out.println( onGround );

    }


    /**
     * Deals with the jumping mechanism. Sets the boolean onGround to false.
     */
    public void OnJumpKeyPressed()
    {
        if ( onGround )
        {
            velocityY = -12f; // Give a vertical boost to the players velocity
                              // to start jump
            try
            {
                // System.out.println("hi");
                image = ImageIO.read( getClass().getResourceAsStream( "/Resources/Sprites/Player/running1.png" ) );
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            onGround = false;
        }
    }


    /**
     * Turns the jump boolean to true when the space key is pressed
     * @param k key pressed
     */
    public void keyPressed( int k )
    {
        if ( k == KeyEvent.VK_SPACE )
        {
            jumped = true;
        }
    }


    /**
     * Draws the character
     * @param g Graphics2D 
     */
    public void draw( Graphics2D g )
    {
        g.drawImage( image, (int)x, (int)y, 58 / 2, 71 / 2, null );
    }
    //For Testing Use Only:
    
    public BufferedImage getImage()
    {
        return image;
    }
     
    public double getVelocityX()
    {
        return velocityX;
    }
     
    public double getVelocityY()
    {
        return velocityY;
    }
     
    public double getGravity()
    {
        return gravity;
    }
     
    public int getAnimation()
    {
        return animation;
    }
     
    public boolean getJumped()
    {
        return jumped;
    }
     
    public double getTime()
    {
        return time;
    }
     
    public double getCount()
    {
        return count;
    }
     
    public boolean getGround()
    {
        return onGround;
    }
     
    public void setGround(boolean bool)
    {
        onGround = bool;
    }
     
    public void setJumped(boolean bool)
    {
        jumped = bool;
    }
     
    public void setCount (int ct)
    {
        count = ct;
    }
     
    public void setVelocities(double dx, double dy)
    {
        velocityX = dx;
        velocityY = dy;
    }
     
    public void setY(double newY)
    {
        y= newY;
    }

}