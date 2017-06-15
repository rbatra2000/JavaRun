package Backgrounds;

import java.awt.*;

import java.awt.image.*;

public class BackgroundRunning extends Background
{
    private double vector;

    public BackgroundRunning( String s, boolean m  )
    {
        super( s, m );
        vector = -3;
    }
    
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
