package Main;

import javax.swing.JFrame;

/**
 *  Builds the window and calls the constructors for the game.
 *
 *  @author  Ritik Batra and Johnson Ku
 *  @version May 22, 2017
 *  @author  Period: 2
 *  @author  Assignment: JavaRun
 *
 *  @author  Sources: none
 */
public class Game {
    
    /**
     * Creates the window for the game and initializes the GamePanel to run the game.
     * @param args not used
     */
    public static void main(String[] args) {
        
        JFrame window = new JFrame("Java Run");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
        
    }
    
}
