package Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import javax.swing.JPanel;

import GameState.GameStateManager;


/**
 * Creates a window with specified dimensions for the game. Draws the interface
 * by calling other classes to draw the graphics for the game.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 22, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class GamePanel extends JPanel implements Runnable, KeyListener
{

    // dimensions
    public static final int WIDTH = 480;

    public static final int HEIGHT = 240;

    public static final int SCALE = 2;

    // game thread
    private Thread thread;

    private boolean running;

    private int FPS = 60;

    private long targetTime = 1000 / FPS;

    // image
    private BufferedImage image;

    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;


    /**
     * The constructor for GamePanel sets the dimensions of the window
     */
    public GamePanel()
    {
        super();
        setPreferredSize( new Dimension( WIDTH * SCALE, HEIGHT * SCALE ) );
        setFocusable( true );
        requestFocus();
    }


    /**
     * Notifies this component that it now has a parent component. When this
     * method is invoked, the chain of parent components is set up with
     * KeyboardAction event listeners. This method is called by the toolkit
     * internally and should not be called directly by programs.
     */
    public void addNotify()
    {
        super.addNotify();
        if ( thread == null )
        {
            thread = new Thread( this );
            addKeyListener( this );
            thread.start();
        }
    }


    private void init()
    {

        image = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB );
        g = (Graphics2D)image.getGraphics();

        running = true;

        gsm = new GameStateManager();

    }


    /**
     * Updates and draws the graphics in the game window while the game is
     * running.
     */
    public void run()
    {

        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while ( running )
        {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = targetTime - elapsed / 1000000;
            if ( wait < 0 )
                wait = 5;

            try
            {
                Thread.sleep( wait );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }

        }

    }


    private void update()
    {
        gsm.update();
    }


    private void draw()
    {
        gsm.draw( g );
    }


    private void drawToScreen()
    {
        Graphics g2 = getGraphics();
        g2.drawImage( image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null );
        g2.dispose();
    }


    public void keyTyped( KeyEvent key )
    {
    }


    /**
     * An event which indicates that a keystroke occurred in a component.
     * 
     * @param key
     *            KeyEvent
     */
    public void keyPressed( KeyEvent key )
    {
        gsm.keyPressed( key.getKeyCode() );
    }


    /**
     * An event which indicates that a key has been released in a component.
     * 
     * @param key
     *            KeyEvent
     */
    public void keyReleased( KeyEvent key )
    {
        gsm.keyReleased( key.getKeyCode() );
    }

}