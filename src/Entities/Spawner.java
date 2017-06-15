package Entities;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Queue;

import Main.GamePanel;


public class Spawner
{
    private Queue<Enemies> spawn;

    private int rate;

    private int count;

    private boolean gameOver;

    private MainCharacter m;
    
    private int webSpd = 4;
    
    private int googSpd = 3;


    public Spawner( MainCharacter main )
    {
        spawn = new LinkedList<Enemies>();
        rate = 40;
        gameOver = false;
        m = main;
    }


    public void removeAll()
    {
        spawn.clear();
    }


    public void update()
    {
        for ( Enemies en : spawn )
        {
            en.update();
            if ( en.toString().equals( "GoogleSheets" ) )
            {
                if ( (int)en.getX() + 10 >= (int)m.getX() - 10 && (int)en.getX() - 10 <= (int)m.getX() + 10
                    && (int)en.getY() + 20 >= (int)m.getY() && (int)en.getY()<= (int)m.getY() + 20)
                {
                    gameOver = true;
                }
            }
            if ( en.toString().equals( "WebCat" ) )
            {
                if ( (int)en.getX() + 30 >= (int)m.getX() - 10 && (int)en.getX() - 10 <= (int)m.getX() + 20
                    && (int)en.getY() + 10 >= (int)m.getY() && (int)en.getY() - 10 <= (int)m.getY() )
                {
                    gameOver = true;
                }
            }
        }
        if ( spawn.peek() != null && !spawn.peek().exists() )
        {
            spawn.remove();
        }
        if ( spawn.size() <= 4 && count >= 30 )
        {
            if ( (int)( Math.random() * rate ) == 0 )
            {
                count = 0;
                int i = (int)( Math.random() * 2 );
                if ( i == 0 )
                {
                    spawn.add(
                        new GoogleSheets( "/Resources/Sprites/Enemies/googlesheets.png", GamePanel.WIDTH, 160, googSpd ) );
                }
                else if ( i == 1 )
                {
                    spawn.add( new WebCat( "/Resources/Sprites/Enemies/webcat.png", GamePanel.WIDTH, 160, webSpd ) );
                }
            }
        }
        count++;
    }


    public void draw( Graphics2D g )
    {
        for ( Enemies en : spawn )
        {
            en.draw( g );
        }
    }


    public boolean gameOver()
    {
        return gameOver;
    }
    
    public void setSpeeds(int spd1, int spd2)
    {
        webSpd = spd1;
        googSpd = spd2;
    }
    
    //For Testing Purposes:
    public boolean isEmpty()
    {
        return spawn.isEmpty();
    }
    
    public int getWeb()
    {
        return webSpd;
    }
    
    public int getGoog()
    {
        return googSpd;
    }
    
    public Queue<Enemies> getSpawn()
    {
        return spawn;
    }
    
    public int getRate()
    {
        return rate;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public MainCharacter getMain()
    {
        return m;
    }
    
    public void setGameOver(boolean b)
    {
        gameOver = b;
    }
    
    public void setCount(int c)
    {
        count = c;
    }
    
    public void setRate(int r)
    {
        rate = r;
    }
    
    public int getSize()
    {
        return spawn.size();
    }
}
