package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import Backgrounds.Background;
import Main.GamePanel;


/**
 * Creates a Game Over screen when the character dies. Displays the score of the
 * last game that was played and gives options for the user to retry, return to
 * main menu, or quit.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 22, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class GameOver extends GameState
{

    private Background bg;

    private int currentChoice = 0;

    private String[] options = { "Retry", "Main Menu", "Quit" };

    private Font scoreFont;

    private Font font;

    private Font titleFont;

    private int score;

    private Color titleColor;


    /**
     * Sets the background picture and creates the different fonts. Sets the
     * GameOver class as one of the game states in GameStateManager
     * 
     * @param gsm
     *            GameStateManager
     */
    public GameOver( GameStateManager gsm )
    {

        this.gsm = gsm;

        try
        {

            bg = new Background( "/Resources/Backgrounds/back.jpg", false );
            bg.setVector( 0, 1 );

            scoreFont = new Font( "Verdana", Font.BOLD, 75 );

            titleFont = new Font( "Verdana", Font.BOLD, 28 );

            font = new Font( "Verdana", Font.BOLD, 12 );
            titleColor = new Color( 64, 224, 208 );

        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

    }


    /**
     * Updates any changes to the background
     */
    public void update()
    {
        bg.update();
    }


    /**
     * Transfers the score from LevelOne
     * 
     * @param sc
     *            Player score
     */
    public void setScore( int sc )
    {
        score = sc;
    }


    /**
     * Draws the screen title, score, and options in yellow. The option that is
     * selected turns red.
     */
    public void draw( Graphics2D g )
    {

        // draw bg
        bg.draw( g );

        // draw title
        g.setColor( titleColor );
        g.setFont( titleFont );
        g.drawString( "GAME OVER", 147, 50 );

        // draw score

        g.setFont( scoreFont );
        String sc = "" + score;
        int x = GamePanel.WIDTH / 2 - sc.length() * 25;
        g.drawString( "" + score, x, 140 );

        // draw menu options
        g.setFont( font );
        for ( int i = 0; i < options.length; i++ )
        {
            if ( currentChoice == i )
            {
                g.setColor( Color.RED );
            }
            if ( i == 0 )
            {
                g.drawString( options[0], 227, 180 );
            }
            else if ( i == 1 )
            {
                g.drawString( options[1], 210, 195 );
            }
            else
            {
                g.drawString( options[2], 230, 210 );
            }
            g.setColor( Color.YELLOW );
        }
    }


    @SuppressWarnings("static-access")
    private void select()
    {
        gsm.lvl = new LevelOne( gsm );
        gsm.reset( gsm.LEVELONE, gsm.lvl );
        gsm.menu = new MenuState( gsm );
        gsm.reset( gsm.MENUSTATE, gsm.menu );
        if ( currentChoice == 0 )
        {
            gsm.setState( gsm.LEVELONE );
        }
        if ( currentChoice == 1 )
        {
            gsm.setState( gsm.MENUSTATE );
        }
        if ( currentChoice == 2 )
        {
            System.exit( 0 );
        }
    }


    /**
     * Select option when enter key is pressed, moves up one option if up key is
     * pressed, down if down key is pressed
     * 
     * @param k
     *            key pressed
     */
    public void keyPressed( int k )
    {
        if ( k == KeyEvent.VK_ENTER )
        {
            select();
        }
        if ( k == KeyEvent.VK_UP )
        {
            currentChoice--;
            if ( currentChoice == -1 )
            {
                currentChoice = options.length - 1;
            }
        }
        if ( k == KeyEvent.VK_DOWN )
        {
            currentChoice++;
            if ( currentChoice == options.length )
            {
                currentChoice = 0;
            }
        }
    }


    public void keyReleased( int k )
    {
    }


    // Testing Uses Only:

    public GameStateManager getGSM()
    {
        return gsm;
    }


    public Background getBack()
    {
        return bg;
    }


    public Color getTitleColor()
    {
        return titleColor;
    }


    public Font getTitleFont()
    {
        return titleFont;
    }


    public Font getScoreFont()
    {
        return scoreFont;
    }


    public Font getFont()
    {
        return font;
    }


    public int getScore()
    {
        return score;
    }


    public int getChoice()
    {
        return currentChoice;
    }


    public String toString()
    {
        return "GameOver";
    }


    public void setCurrentChoice( int cc )
    {
        currentChoice = cc;
    }

}
