package Entities;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.awt.*;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Entities.MainCharacter;


public abstract class Enemies
{
    private BufferedImage image;

    private double x;

    private double y;

    private double speed;

    private boolean onScreen;


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


    public abstract void update();

    public void offScreen()
    {
        onScreen = false;
    }

    public double speed()
    {
        return speed;
    }
    
    public void setSpeed( double num )
    {
        speed = num;
    }
    public void setX( double num )
    {
        x = num;
    }
    
    public void setY(double num)
    {
        y = num;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public abstract void draw( Graphics2D g );
    
    public BufferedImage getImage()
    {
        return image;
    }
    
    public boolean exists()
    {
        return onScreen;
    }
    
    public abstract String toString();

}
