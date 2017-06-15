package GameState;

import java.awt.Color;





import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;

import Backgrounds.*;
import Entities.*;
import Main.*;

public class LevelOne extends GameState implements ImageObserver
{

    private BackgroundRunning bg;
    private MainCharacter ply;
    private PowersSpawner ps;
    private Spawner s;
    private int score;
    private int count;

    public LevelOne(GameStateManager gsm) {
        
        this.gsm = gsm;
        score = 0;
        count = 0;
        
        try {
            
            bg = new BackgroundRunning("/Resources/Backgrounds/grassbg.jpg", true);
            ply = new MainCharacter("/Resources/Sprites/Player/standing.png", 100,160);
            s = new Spawner( ply );
            ps = new PowersSpawner(ply, bg, s);
            
            
            //bg.setVector(-1, 0);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
  
    public int getScore()
    {
        return score;
    }


    public void update()
    {
        count++;
        ply.update();
        bg.update();
        ps.update();
        s.update();
        if (count >= 15)
        {
            score++;
            count = 0;
        }   
        if( s.gameOver() )
        {
            gsm.setState( GameStateManager.GAMEOVER );
        }
    }
    
    public void draw(Graphics2D g) {
        
        // draw bg
        bg.draw(g);
        
        // draw character
        ply.draw( g );
        if (ply.getJumped())
        {
            ply.OnJumpKeyPressed();
            ply.setJumped(false);
        }

        Font titleFont = new Font( "Verdana", Font.PLAIN, 12 );
        g.setColor( Color.RED );
        g.setFont( titleFont );
        g.drawString("Score: " + score, 5, 10);
        
        s.draw( g );
        
        //draw powerups
        ps.draw( g );
    }
    

    public void keyPressed( int k )
    {
        ply.keyPressed( k );
    }
    
    
    public void keyReleased(int k) {}
    public boolean imageUpdate( Image img, int infoflags, int x, int y, int width, int height )
    {
        return false;
    }
    
    //For Testing Use Only:
    
    public String toString()
    {
        return "LevelOne";
    }
    
    public void setScore(int sc)
    {
        score = sc;
    }
    
    public BackgroundRunning getBack()
    {
        return bg;
    }
    
    public MainCharacter getMain()
    {
        return ply;
    }
    
    public PowersSpawner getPowsSpawner()
    {
        return ps;
    }
    
    public Spawner getSpawner()
    {
        return s;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setCount(int ct)
    {
        count = ct;
    }
    
    public GameStateManager getGSM()
    {
        return gsm;
    }
    
}