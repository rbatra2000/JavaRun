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


/**
 * The game state for the game to run in.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 23, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class LevelOne extends GameState implements ImageObserver
{

    private BackgroundRunning bg;

    private MainCharacter ply;

    private PowersSpawner ps;

    private Spawner s;

    private int score;

    private int count;


    /**
     * Initializes all of the spawners, main character, and backgrounds.
     * 
     * @param gsm
     *            GameStateManager
     */
    public LevelOne( GameStateManager gsm )
    {

        this.gsm = gsm;
        score = 0;
        count = 0;

        try
        {

            bg = new BackgroundRunning( "/Resources/Backgrounds/grassbg.jpg", true );
            ply = new MainCharacter( "/Resources/Sprites/Player/standing.png", 100, 160 );
            s = new Spawner( ply );
            ps = new PowersSpawner( ply, bg, s );

            // bg.setVector(-1, 0);
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }


    /**
     * Returns player's score for the game
     * 
     * @return score
     */
    public int getScore()
    {
        return score;
    }


    /**
     * Updates the background and the entities. If the character dies, sets the
     * screen to the game over state
     */
    public void update()
    {
        count++;
        ply.update();
        bg.update();
        ps.update();
        s.update();
        if ( count >= 15 )
        {
            score++;
            count = 0;
        }
        if ( s.gameOver() )
        {
            gsm.setState( gsm.GAMEOVER );
        }
    }


    /**
     * Draws each of the entities and the background. Prevents character from
     * jumping again if the character is off the ground.
     * 
     * @param g
     *            Graphics2D
     */
    public void draw( Graphics2D g )
    {

        // draw bg
        bg.draw( g );

        // draw character
        ply.draw( g );
        if ( ply.jumped )
        {
            ply.OnJumpKeyPressed();
            ply.jumped = false;
        }

        Font titleFont = new Font( "Verdana", Font.PLAIN, 12 );
        g.setColor( Color.RED );
        g.setFont( titleFont );
        g.drawString( "Score: " + score, 5, 10 );

        s.draw( g );

        // draw powerups
        ps.draw( g );

    }


    /**
     * Calls the MainCharacter keyPressed method.
     * 
     * @param k
     *            key pressed
     */
    public void keyPressed( int k )
    {
        ply.keyPressed( k );
    }


    public void keyReleased( int k )
    {
    }


    /**
     * This method is called when information about an image which was
     * previously requested using an asynchronous interface becomes available.
     */
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