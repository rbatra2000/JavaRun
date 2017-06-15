package GameState;

import java.util.ArrayList;


/**
 * Manages all the game states by creating an ArrayList of possible game states.
 * Each game state is initialized in this class and assigned a number.
 *
 * @author Ritik Batra
 * @version May 24, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class GameStateManager
{

    private ArrayList<GameState> gameStates;

    private int currentState;

    public static final int MENUSTATE = 0;

    public static final int LEVELONE = 1;

    public static final int GAMEOVER = 2;

    public static final int HELP = 3;

    public MenuState menu;

    public LevelOne lvl;

    public GameOver over;

    public HelpScreen help;


    /**
     * Initializes the ArrayList of game states and creates the different game
     * states to add into the ArrayList.
     */
    public GameStateManager()
    {

        gameStates = new ArrayList<GameState>();

        menu = new MenuState( this );
        lvl = new LevelOne( this );
        over = new GameOver( this );
        help = new HelpScreen( this );

        currentState = MENUSTATE;
        gameStates.add( menu );
        gameStates.add( lvl );
        gameStates.add( over );
        gameStates.add( help );
        // System.out.println("CHECK");
    }


    /**
     * Resets the game state to its default state. 
     * @param index GameState index
     * @param gs GameState name
     */
    public void reset( int index, GameState gs )
    {
        gameStates.set( index, gs );
    }


    /**
     * Sets the current game state to the specified game state
     * @param state GameState
     */
    public void setState( int state )
    {
        currentState = state;
    }


    /**
     * Updates the current game state
     */
    public void update()
    {
        gameStates.get( currentState ).update();
        over.setScore( lvl.getScore() );
        // System.out.println(currentState);
    }


    /**
     * Draws the graphics for the current state.
     * @param g Graphics2D
     */
    public void draw( java.awt.Graphics2D g )
    {
        gameStates.get( currentState ).draw( g );
    }


    /**
     * Calls the keyPressed method in the current game state
     * @param k key pressed
     */
    public void keyPressed( int k )
    {
        gameStates.get( currentState ).keyPressed( k );
    }


    /**
     * Calls the keyReleased method in the current game state
     * @param k key pressed
     */
    public void keyReleased( int k )
    {
        gameStates.get( currentState ).keyReleased( k );
    }

    //For Testing Use Only:
    
    public ArrayList<GameState> getStates()
    {
        return gameStates;
    }
     
    public int getState()
    {
        return currentState;
    }
     
}