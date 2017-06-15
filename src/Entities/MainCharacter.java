package Entities;


import java.awt.event.KeyEvent;



import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MainCharacter
{

    private BufferedImage image;

    private double x;

    private double y;

    private double velocityX, velocityY; // Velocity of the character

    private double gravity = 0.5f; // How strong is gravity

    private boolean onGround;
    
    private int animation;
    
    private double count;
    
    private boolean jumped;
    
    private double time = 1;


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


    public void setTime (double num)
    {
        time = num;
    }
    
    public void setPosition( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    public void setAnimation(int speed)
    {
        animation = speed;
    }

    public double getX()
    {
        return x;
    }


    public double getY()
    {
        return y;
    }


    public void update()
    {
        if (onGround)
        {
            try
            {
                if ( count < animation )
                {
                    image = ImageIO.read( getClass().getResourceAsStream(
                        "/Resources/Sprites/Player/running1.png" ) );
                }
                else if (count >= animation)
                {
                    image = ImageIO.read( getClass().getResourceAsStream(
                        "/Resources/Sprites/Player/standing.png" ) );
                }
                if (count >= animation * 2)
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
        //System.out.println(count);
        if (onGround)
        {
            count++;
        }
        //System.out.println( onGround );
    }


    public void OnJumpKeyPressed()
    {
        if ( onGround )
        {
            velocityY = -12f; // Give a vertical boost to the players velocity
                                // to start jump
            try
            {
                //System.out.println("hi");
                image = ImageIO.read( getClass().getResourceAsStream(
                    "/Resources/Sprites/Player/running1.png" ) );
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            onGround = false;
        }
    }


    public void keyPressed( int k )
    {
        if ( k == KeyEvent.VK_SPACE )
        {
            jumped = true;
        }
    }


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