package Backgrounds;

import java.awt.*;
import java.awt.image.*;

/**
 *  Creates a moving background where the changes in x and y can be easily manipulated.
 *
 *  @author  Ritik Batra and Johnson Ku
 *  @version May 24, 2017
 *  @author  Period: 2
 *  @author  Assignment: JavaRun
 *
 *  @author  Sources: none
 */
public class BackgroundRunning extends Background
{
    private double vector;

    /**
     * Calls super constructor and sets vector to -3
     * @param s image location
     * @param m move
     */
    public BackgroundRunning( String s, boolean m  )
    {
        super( s, m );
        vector = -3;
    }
    
    /**
     * Updates the positions of x and y
     */
    public void update()
    {
        super.setVector( vector, 0 );
        //System.out.println(super.x);

        if ( super.x <= -480)
        {
            //System.out.println("hi");
            super.x = 0;
        }
        super.update();
    }
    
    /**
     * Sets the speed of the moving image.
     * @param vec speed of background
     */
    public void setVector(double vec)
    {
        vector = vec;
    }
    
    //For testing use only
    public double getVector()
    {
        return vector;
    }
}
