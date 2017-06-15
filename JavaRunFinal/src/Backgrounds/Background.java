package Backgrounds;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;


/**
 * 
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 24, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class Background
{

    public BufferedImage image;

    public double x;

    public double y;

    private double dx;

    private double dy;

    private boolean move;


    /**
     * Sets the image as the file provided by the string.
     * @param s image file
     * @param m move
     */
    public Background( String s, boolean m )
    {

        try
        {
            image = ImageIO.read( getClass().getResourceAsStream( s ) );
            move = m;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

    }


    /**
     * Gets change in X
     * @return double 
     */
    public double getVectorX()
    {
        return dx;
    }


    /**
     * Gets change in Y
     * @return double
     */
    public double getVectorY()
    {
        return dy;
    }


    /**
     * Sets the changes in x and y
     * @param dx double
     * @param dy double
     */
    public void setVector( double dx, double dy )
    {
        this.dx = dx;
        this.dy = dy;
    }


    /**
     * Moves the screen if the move boolean is true
     */
    public void update()
    {
        if ( move )
        {
            x += dx;
            y += dy;
        }
    }


    /**
     * Draws the image the same size of the screen
     * @param g Graphics2D
     */
    public void draw( Graphics2D g )
    {

        if ( image.getWidth() >= GamePanel.WIDTH )
        {
            g.drawImage( image, (int)x, (int)y, GamePanel.WIDTH * 2, GamePanel.HEIGHT, null );
        }
        else
        {
            g.drawImage( image, (int)x, (int)y, GamePanel.WIDTH, GamePanel.HEIGHT, null );
        }
    }

    //For Testing Use Only:
    public boolean getMove()
    {
        return move;
    }
}