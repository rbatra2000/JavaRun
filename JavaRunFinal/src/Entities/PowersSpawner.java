package Entities;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Queue;

import Backgrounds.BackgroundRunning;
import Main.GamePanel;


/**
 * Class that controls the creating of the powerups
 *
 * @author Ritik Batra and Johnson Ku
 * @version May 26, 2017
 * @author Period: 2
 * @author Assignment: JavaRun
 *
 * @author Sources: none
 */
public class PowersSpawner
{
    private Queue<PowerUps> spawn;

    private int rate;

    private int count;

    private MainCharacter m;

    private BackgroundRunning bg;

    private Spawner s;


    /**
     * Initializes the fields and creates the queue for the powerups
     * 
     * @param main
     *            runner
     * @param b
     *            background
     * @param sp
     *            enemy spawner
     */
    public PowersSpawner( MainCharacter main, BackgroundRunning b, Spawner sp )
    {
        spawn = new LinkedList<PowerUps>();
        bg = b;
        s = sp;
        rate = 40;
        m = main;
        count = 150;
    }


    /**
     * Updates the power ups in the queue and removes the power up once it is
     * off the screen. Spawns a powerup randomly after certain intervals
     */
    public void update()
    {
        // System.out.println(spawn.size());
        for ( PowerUps pow : spawn )
        {
            pow.update();
        }

        // System.out.println(count);

        if ( spawn.peek() != null && !spawn.peek().exists() )
        {
            spawn.remove();
        }

        if ( count >= 150 )
        {
            int random = (int)( Math.random() * rate );

            // System.out.println(random);
            if ( random == 0 )
            {
                count = 0;
                int i = (int)( Math.random() * 2 );
                if ( i <= 0 )
                {
                    spawn.add( new SlowDown( "/Resources/Sprites/github.png", 600, 25, m, bg, s ) );
                }
                else if ( i <= 1 )
                {
                    spawn.add( new DropBox( "/Resources/Sprites/dropbox.png", 600, 25, m, bg, s ) );
                }
                rate = 500;
            }
        }
        count++;
    }


    /**
     * Draws each of the powerups
     * @param g Graphics2D
     */
    public void draw( Graphics2D g )
    {
        for ( PowerUps p : spawn )
        {
            p.draw( g );
        }
    }


    public Queue<PowerUps> getSpawn()
    {
        return spawn;
    }
     
    public int getRate()
    {
        return rate;
    }
     
    public int getCount()
    {
        return count;
    }
     
    public MainCharacter getMain()
    {
        return m;
    }
     
    public BackgroundRunning getBack()
    {
        return bg;
    }
     
    public Spawner getSpawner()
    {
        return s;
    }
     
    public void setCount( int ct)
    {
        count = ct;
    }
     
    public void setRate (int rt)
    {
        rate = rt;
    }
}
