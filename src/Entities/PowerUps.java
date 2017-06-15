package Entities;

import java.awt.*;

public abstract class PowerUps
{
    public abstract void draw( Graphics2D g);
    public abstract void update();
    public abstract void setVector(double a, double b);
    public abstract boolean exists();
    
}
