package Entities;

import java.awt.Graphics2D;

import Main.GamePanel;


public class GoogleSheets extends Enemies
{
    public GoogleSheets( String s, int x, int y, double spd )
    {
        super( s, x, y, spd );
    }

    public void update()
    {
        setX( getX() - speed() );
        if ( getX() < 0 )
        {
            offScreen();
        }
    }
    public void draw(Graphics2D g )
    {
        g.drawImage( getImage(), (int)getX(), (int)getY(), 30, 30, null );
    }
    
    public String toString()
    {
        return "GoogleSheets";
    }
}
