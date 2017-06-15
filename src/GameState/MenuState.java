package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import Backgrounds.Background;

public class MenuState extends GameState {
    
    private Background bg;
    
    private int currentChoice = 0;
    private String[] options = {
        "Start",
        "Help",
        "Quit"
    };
    
    private Color titleColor;
    private Font titleFont;
    
    private Font font;
    
    public MenuState(GameStateManager gsm) {
        
        this.gsm = gsm;
        
        try {
            
            bg = new Background("/Resources/Backgrounds/back.jpg", false);
            bg.setVector(0, 1);
            
            titleColor = new Color(64, 224, 208);
            titleFont = new Font(
                    "Verdana",
                    Font.BOLD,
                    28);
            
            font = new Font("Verdana", Font.BOLD, 12);
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    public void update() {
        bg.update();
    }
    
    public void draw(Graphics2D g) {
        
        // draw bg
        bg.draw(g);
        
        // draw title
        g.setColor(Color.YELLOW);
        g.setFont(titleFont);
        g.drawString("Java Run", 170, 70);
        
        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.RED);
            }
            else {
                g.setColor(Color.YELLOW);
            }
            g.drawString(options[i], 230, 140 + i * 15);
        }
        
    }
    
    private void select() {
        if(currentChoice == 0) {
            gsm.setState( GameStateManager.LEVELONE );
        }
        if(currentChoice == 1) {
            gsm.setState( GameStateManager.HELP );
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }
    
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }
    public void keyReleased(int k) {}
    
    
    //Testing Uses Only:
    
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
    
    public Font getFont()
    {
        return font;
    }
    public String toString()
    {
        return "MenuState";
    }
    
    public void setCurrentChoice(int cc)
    {
        currentChoice = cc;
    }
    
    public int getChoice()
    {
        return currentChoice;
    }
}
