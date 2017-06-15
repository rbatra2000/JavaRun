package Backgrounds;

import Main.GamePanel;


import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Background {
    
    public BufferedImage image;
    
    public double x;
    public double y;
    private double dx;
    private double dy;
    
    private boolean move;
    
    public Background(String s, boolean m) {
        
        try {
            image = ImageIO.read(
                getClass().getResourceAsStream(s)
            );
            move = m;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public double getVectorX()
    {
        return dx;
    }
    
    public double getVectorY()
    {
        return dy;
    }
    
    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public void update() {
        if (move)
        {
            x += dx;
            y += dy;
        }
    }
    
    public void draw(Graphics2D g) {
        
        if (image.getWidth() >= GamePanel.WIDTH)
        {
            g.drawImage( image, (int)x, (int)y, GamePanel.WIDTH*2, GamePanel.HEIGHT, null );
        }
        else
        {
            g.drawImage(image, (int)x, (int)y, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        }
    }
    
    //For Testing Use Only:
    public boolean getMove()
    {
        return move;
    }
    
}