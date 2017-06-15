package Entities;

import java.awt.Graphics2D;

public class WebCat extends Enemies
{
    private double velocityY;
    private boolean onGround;
    private double gravity = 0.15f;
    
    public WebCat( String s, int x, int y, double spd )
    {
        super( s, x, y, spd );
        onGround = true;
    }

    public void update()
    {
        setX( getX() - speed() );
        setY( getY() +  velocityY);
        velocityY += gravity;
        if ( getX() < 0 )
        {
            offScreen();
        }
        if ( getY() > 160.0 )
        {
            setY(160);
            velocityY = 0.0;
            onGround = true;
        }
        if(onGround)
        {
            velocityY = Math.random()*-8f;
            onGround = false;
        }
    }
    public void draw(Graphics2D g )
    {
        g.drawImage( getImage(), (int)getX(), (int)getY(), 40, 20, null );
    }
    
    public String toString()
    {
        return "WebCat";
    }
    
    //For Testing Purposes only:
    
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

