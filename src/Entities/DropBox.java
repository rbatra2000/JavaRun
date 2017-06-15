package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Backgrounds.BackgroundRunning;

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
    
    public DropBox( String s, int x, int y, MainCharacter runner, BackgroundRunning bg, Spawner spwn)
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
    
    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public void update()
    {
        //System.out.println( count + "   " + time );
        setVector( -3, 0 );
        // draw( (Graphics2D)image.getGraphics() );
        // System.out.println( x + " " + main.x );
        x += dx;
        if ( x < 0)
        {
            showImage = false;
        }
        
        count++;
    }
    


    public void draw( Graphics2D g )
    {
        // System.out.println("HI");
        // System.out.println(x + " " + y);
        showImage = true;
        g.drawImage( image, (int)x, (int)y, 40, 50, null );
        //System.out.println(x + " " + main.getX() + "*" + y + " " + main.getY());

        if ( main.getX() >= x - 10 && main.getX() <= x + 10 && main.getY() <= y + 15 && main.getY() >= y - 15 )
        {
            spn.removeAll();
            showImage = false;
        }
    }
    
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

