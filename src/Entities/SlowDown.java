package Entities;

import javax.imageio.ImageIO;


import Backgrounds.BackgroundRunning;

import java.awt.*;
import java.awt.image.BufferedImage;
import Entities.MainCharacter;

public class SlowDown extends PowerUps
{
    private BufferedImage image;
    private MainCharacter main;
    private BackgroundRunning back;
    private Spawner sp;
    private int count;
    private double x;
    private double y;
    private double dy;
    private double dx;
    private boolean showImage;
    
    public SlowDown( String s, int x, int y, MainCharacter runner, BackgroundRunning bg, Spawner spawn)
    {
        count = 0;
        showImage = false;
        this.x = x;
        this.y = y;
        sp = spawn;
        main = runner;
        back = bg;
        try
        {
            image = ImageIO.read( getClass().getResourceAsStream( s ) );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
    

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    
    public void update()
    {
        //System.out.println( count + "   " + time );
        setVector( -3, 0 );
        //draw( (Graphics2D)image.getGraphics() );

        if (showImage)
        {
            //System.out.println( x + " " + main.x );
            x += dx;
        }

        // System.out.println("HI");
        if ( count >= 300)
        {
            //System.out.println("HI");
            back.setVector( -3 );
            dx = -2;
            main.setAnimation( 6 );
            count = 0;
            x = 800;
            main.setTime(1);
            for (Enemies en : sp.getSpawn())
            {
                slow(en, 4,3);
            }
            sp.setSpeeds( 4, 3 );
            showImage = false;

        }
        count++;
    }

    public void draw( Graphics2D g )
    {
        // System.out.println("HI");
        // System.out.println(x + " " + y);
        showImage = true;
        g.drawImage( image, (int)x, (int)y, 30, 30, null );
        if ( main.getX() >= x - 20 && main.getX() <= x + 20 && main.getY() <= y + 20 && main.getY() >= y - 20 )
        {
            // System.out.println("HI");
            back.setVector( -0.25 );
            main.setAnimation( 30 );
            main.setTime( 0.25 );
            for (Enemies en : sp.getSpawn())
            {
                slow( en, 2, 1 );
            }
            sp.setSpeeds( 2, 1 );
        }
    }
    
    public boolean exists()
    {
        return showImage;
    }
    
    public void slow(Enemies en, int spd1, int spd2)
    {
        if (en.toString().equals("WebCat"))
        {
            en.setSpeed( spd1 );
        }
        else
        {
            en.setSpeed( spd2 );
        }
    }
    
    // For Testing Use Only:
    
    public int getCount()
    {
        return count;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public Spawner getSpawner()
    {
        return sp;
    }
    
    public BackgroundRunning getBack()
    {
        return back;
    }
    
    public MainCharacter getMain()
    {
        return main;
    }
    
    public BufferedImage getImage()
    {
        return image;
    }
    
    public double getDX()
    {
        return dx;
    }
    
    public double getDY()
    {
        return dy;
    }
    
    public void setExists(boolean bool)
    {
        showImage = bool;
    }
    
    public void setCount(int ct)
    {
        count = ct;
    }

}
