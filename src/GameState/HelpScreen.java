package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Backgrounds.Background;
import Main.GamePanel;

public class HelpScreen extends GameState
{

    private Background bg;
    
    private int currentChoice = 0;
    private String[] options = {
        "Menu"
    };
    
    private Font titleFont;
    
    private Font font;
    
    public HelpScreen(GameStateManager gsm) {
        
        this.gsm = gsm;
        
        try {
            
            bg = new Background("/Resources/Backgrounds/back.jpg", false);
            bg.setVector(0, 1);
            
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

    public void update()
    {
        bg.update();   
    }

    public void draw( Graphics2D g )
    {
        bg.draw(g);
        
        // draw title
        g.setColor(Color.YELLOW);
        g.setFont(titleFont);
        g.drawString("Help", GamePanel.WIDTH/2 - "Help".length()*7, 30);
        
        //help
        g.setColor( Color.GREEN );
        g.setFont( font );
        g.drawString( "Space = Jump", 30 , 70 );
        g.drawString( "This is a story of an APCS student", 30, 90 );
        g.drawString( "who must use his resources to live through a day of APCS", 30, 110 );
        g.drawString( "DropBox & Github are resources", 30, 130 );
        g.drawString( "Google Forms & WEB-CAT are challenges", 30, 150 );
        
        // draw menu option
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.RED);
            }
            else {
                g.setColor(Color.YELLOW);
            }
            g.drawString(options[i], 230, 200 + i * 15);
        }
        
    }
    
    private void select() {
        if(currentChoice == 0) {
            gsm.setState( GameStateManager.MENUSTATE );
        }

    }

    public void keyPressed( int k )
    {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
    }

    
    public void keyReleased( int k )
    {   
    }
    
    //For Testing Uses Only:
    
    public String toString()
    {
        return "HelpScreen";
    }
    
    public GameStateManager getGSM()
    {
        return gsm;
    }
    
    public Background getBack()
    {
        return bg;
    }
    
    public Font getTitleFont()
    {
        return titleFont;
    }
    
    public Font getFont()
    {
        return font;
    }

}
