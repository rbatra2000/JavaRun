package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Backgrounds.BackgroundRunning;


/**
 *  A power up that clears all the enemies present on the screen. 
 *
 *  @author  Ritik Batra and Johnson Ku
 *  @version May 26, 2017
 *  @author  Period: 2
 *  @author  Assignment: JavaRun
 *
 *  @author  Sources: none
 */
public class DropBox extends PowerUps
{
    private BufferedImage image;

    private MainCharacter main;

    private BackgroundRunning back;

    private Spawner spn;

    private int count;

    private double x;

    private double y;

    private double dy;

    private double dx;

    private boolean showImage = true;


    /**
     * Fills in the fields and reads in the string to get them image
     * 
     * @param s image location
     * @param x position
     * @param y position
     * @param runner the main character
     * @param bg moving background
     * @param spwn enemies
     */
    public DropBox( String s, int x, int y, MainCharacter runner, BackgroundRunning bg, Spawner spwn )
    {
        count = 0;
        this.x = x;
        this.y = y;
        main = runner;
        back = bg;
        spn = spwn;
        try
        {
            image = ImageIO.read( getClass().getResourceAsStream( s ) );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }


    /**
     * Sets the change in x and y to the given values
     * 
     * @param dx
     *            change in x
     * @param dy
     *            change in y
     */
    public void setVector( double dx, double dy )
    {
        this.dx = dx;
        this.dy = dy;
    }


    /**
     * Moves the Dropbox across the screen at the given speed. When the dropbox
     * goes off the screen, the boolean will change to false.
     */
    public void update()
    {
        // System.out.println( count + " " + time );
        setVector( -3, 0 );
        // draw( (Graphics2D)image.getGraphics() );
        // System.out.println( x + " " + main.x );
        x += dx;
        if ( x < 0 )
        {
            showImage = false;
        }

        count++;
    }


    /**
     * Draws the image. If the character hits the dropbox, the powerup will be
     * activated and the enemies present will be cleared off the screen.
     */
    public void draw( Graphics2D g )
    {
        // System.out.println("HI");
        // System.out.println(x + " " + y);
        showImage = true;
        g.drawImage( image, (int)x, (int)y, 40, 50, null );
        // System.out.println(x + " " + main.getX() + "*" + y + " " +
        // main.getY());

        if ( main.getX() >= x - 10 && main.getX() <= x + 10 && main.getY() <= y + 15 && main.getY() >= y - 15 )
        {
            spn.removeAll();
            showImage = false;
        }
    }


    /**
     * Returns if the image is on the screen
     * 
     * @return showImage
     */
    public boolean exists()
    {
        return showImage;
    }


    //For Testing Use Only:
    
    public BufferedImage getImage()
    {
        return image;
    }
     
    public MainCharacter getMain()
    {
        return main;
    }
     
    public BackgroundRunning getBack()
    {
        return back;
    }
     
    public Spawner getSpawn()
    {
        return spn;
    }
     
    public double getVectorX()
    {
        return dx;
    }
     
    public double getVectorY()
    {
        return dy;
    }
     
    public double getX()
    {
        return x;
    }
     
    public double getY()
    {
        return y;
    }
     
    public double getCount()
    {
        return count;
    }
 
    public void setCount(int c)
    {
        count = c;
    }
     
    public void setXY( double a, double b)
    {
        x = a;
        y = b;
    }
     
    public void setShowImage(boolean bool)
    {
        showImage = bool;
    }
}
