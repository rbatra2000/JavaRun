package GameState;

/**
 * Abstract class for the different game states.
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 24, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public abstract class GameState
{

    protected GameStateManager gsm;


    /**
     * Updates all the values needed to run the game.
     */
    public abstract void update();


    /**
     * Draws the graphics
     * 
     * @param g
     *            Graphics2D
     */
    public abstract void draw( java.awt.Graphics2D g );


    /**
     * Method to deal with user inputs.
     * 
     * @param k key pressed
     */
    public abstract void keyPressed( int k );


    /**
     * Method to deal with user inputs.
     * @param k key pressed
     */
    public abstract void keyReleased( int k );

}
