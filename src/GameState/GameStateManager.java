package GameState;

import java.util.ArrayList;

public class GameStateManager {
    
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
        
    
    public GameStateManager() {
        
        gameStates = new ArrayList<GameState>();
        
        menu = new MenuState(this);
        lvl = new LevelOne(this);
        over =  new GameOver(this );
        help = new HelpScreen(this);
        
        
        currentState = MENUSTATE;
        gameStates.add(menu);
        gameStates.add(lvl);
        gameStates.add(over);
        gameStates.add( help );
        //System.out.println("CHECK");
    }

    public void reset (int index, GameState gs)
    {
        gameStates.set( index, gs );
    }
    public void setState(int state) {
        currentState = state;        
    }
    
    public void update() {
        gameStates.get(currentState).update();
        over.setScore( lvl.getScore() );
        //System.out.println(currentState);
    }
    
    public void draw(java.awt.Graphics2D g) {
        gameStates.get(currentState).draw(g);
    }
    
    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);
    }
    
    public void keyReleased(int k) {
        gameStates.get(currentState).keyReleased(k);
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