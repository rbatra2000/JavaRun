package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Map;

import Backgrounds.*;
import Entities.*;
import GameState.*;
import Main.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import sun.misc.Queue;


public class JUnitJavaRunTest
{

    // Background Tests
    /**
     * Background tests:
     * 
     * BackgroundConstructor - checks to make sure fields are correct
     * BackgroundGetVectorX - returns x value BackgroundGetVectorY - returns y
     * value BackgroundSetVector - sets x and y values BackgroundUpdate -
     * changes x and y values
     * 
     */

    /**
     * Private double used in testing
     */
    private double val1 = 3;

    /**
     * Private double used in testing
     */
    private double val2 = 5;

    /**
     * Background class
     */
    private Background bg = new Background( "/Resources/Sprites/Player/standing.png", true );


    @Test
    public void backgroundConstructor()
    {
        assertNotNull( "<< Invalid Background Constructor >>", bg.image );
        assertTrue( "<< Invalid Background Constructor >>", bg.getMove() );
    }


    @Test
    public void backgroundGetVectorX()
    {
        bg.setVector( val1, val2 );
        assertEquals( "<< X Vector should be " + val1 + " >>", bg.getVectorX(), val1, 0.01 );
    }


    @Test
    public void backgroundGetVectorY()
    {
        bg.setVector( val1, val2 );
        assertEquals( "<< Y Vector should be " + val2 + " >>", bg.getVectorY(), val2, 0.01 );
    }


    @Test
    public void backgroundSetVector()
    {
        bg.setVector( val1, val2 );
        assertEquals( "<< X Vector should be " + val1 + " >>", bg.getVectorX(), val1, 0.01 );
        assertEquals( "<< Y Vector should be " + val2 + " >>", bg.getVectorY(), val2, 0.01 );
    }


    @Test
    public void backgroundUpdate()
    {
        bg.setVector( val1, val2 );
        bg.update();
        assertEquals( "<< X should be " + val1 + " >>", bg.x, val1, 0.01 );
        assertEquals( "<< Y should be " + val2 + " >>", bg.y, val2, 0.01 );
    }

    // BackgroundRunning Tests
    /**
     * BackgroundRunning tests:
     * 
     * BackgroundRunningConstructor - checks to make sure fields are correct
     * BackgroundRunningUpdate - checks to make sure x and y change accordingly
     * BackgroundRunningSetVector - changes vector BackgroundRunningGetVector -
     * returns vector
     * 
     */

    /**
     * Background Running Class
     */
    BackgroundRunning bg1 = new BackgroundRunning( "/Resources/Sprites/Player/standing.png", true );


    @Test
    public void backgroundRunningConstructor()
    {
        assertEquals( "<< Invalid BackgroundRunning Constructor >>", -3, bg1.getVector(), 0.01 );
    }


    @Test
    public void backgroundRunningUpdate()
    {
        BackgroundRunning bg1 = new BackgroundRunning( "/Resources/Sprites/Player/standing.png", false );
        bg1.x = -500;
        bg1.update();
        assertEquals( "<< VectorX should be " + -3 + " >>", -3, bg1.getVectorX(), 0.01 );
        assertEquals( "<< VectorY should be " + 0 + " >>", 0, bg1.getVectorY(), 0.01 );
        assertEquals( "<< X should be " + 0 + " >>", 0, bg1.x, 0.01 );
    }


    @Test
    public void backgroundRunningSetVector()
    {
        bg1.setVector( -5 );
        assertEquals( "<< Vector should be " + -5 + " >>", -5, bg1.getVector(), 0.01 );
    }


    @Test
    public void backgroundRunningGetVector()
    {
        bg1.setVector( -5 );
        assertEquals( "<< Vector should be " + -5 + " >>", -5, bg1.getVector(), 0.01 );
    }

    // DropBox
    /**
     * Dropbox tests:
     * 
     * DropboxConstructor - checks to make sure fields are correct
     * DropBoxSetVector - sets x and y values DropBoxUpdate - checks method
     * updated every second DropBoxDraw - Makes sure the dropbox gets rid of all
     * enemies on screen
     * 
     */

    /**
     * MainCharacter class
     */
    private MainCharacter m = new MainCharacter( "/Resources/Sprites/Player/standing.png", 100, 160 );

    /**
     * Spawner Class
     */
    private Spawner s = new Spawner( m );

    /**
     * DropBox class
     */
    private DropBox db = new DropBox( "/Resources/Sprites/dropbox.png", 600, 25, m, bg1, s );


    @Test
    public void dropBoxConstructor()
    {
        assertEquals( "<< Invalid DropBox Constructor (X location) >>", 600, db.getX(), 0.01 );
        assertEquals( "<< Invalid DropBox Constructor (Y location) >>", 25, db.getY(), 0.01 );
        assertEquals( "<< Invalid DropBox Constructor (count) >>", 0, db.getCount(), 0.01 );
        assertNotNull( "<< Invalid DropBox Constructor (back) >>", db.getBack() );
        assertNotNull( "<< Invalid DropBox Constructor (main) >>", db.getMain() );
        assertNotNull( "<< Invalid DropBox Constructor (spawn) >>", db.getSpawn() );
        assertNotNull( "<< Invalid DropBox Constructor (image) >>", db.getImage() );
    }


    @Test
    public void dropBoxSetVector()
    {
        db.setVector( val1, val2 );
        assertEquals( "<< X Vector should be " + val1 + " >>", db.getVectorX(), val1, 0.01 );
        assertEquals( "<< Y Vector should be " + val2 + " >>", db.getVectorY(), val2, 0.01 );
    }


    @Test
    public void dropBoxUpdate()
    {
        db.draw( db.getImage().createGraphics() );
        db.update();
        assertEquals( "<< VectorX should be " + -3 + " >>", -3, db.getVectorX(), 0.01 );
        assertEquals( "<< X should be " + 597 + " >>", 597, db.getX(), 0.01 );
        db.setXY( -5, 325 );
        db.update();
        assertFalse( "<< showImage should be false >>", db.exists() );

    }


    @Test
    public void dropBoxDraw()
    {
        db.setXY( 100, 160 );
        db.draw( db.getImage().createGraphics() );
        assertFalse( "<< showImage should be false >>", db.exists() );
        assertTrue( "<< Spawner should be empty >>", db.getSpawn().isEmpty() );
    }

    // Enemies
    /**
     * Enemies tests:
     * 
     * EnemiesConstructor - checks to make sure fields are correct
     * EnemiesOffScreen - gets onScreen EnemiesSetSpeed - sets enemy speed
     * EnemiesSetX - sets enemy x position EnemiesSetY - sets enemy y position
     * 
     */

    /**
     * Enemies class (in form of GoogleSheets)
     */
    private Enemies en = new GoogleSheets( "/Resources/Sprites/Enemies/googlesheets.png", 30, 160, 3 );


    @Test
    public void enemiesConstructor()
    {
        assertEquals( "<< Invalid Enemies Constructor >>", en.getX(), 30, 0.01 );
        assertEquals( "<< Invalid Enemies Constructor >>", en.getY(), 160, 0.01 );
        assertEquals( "<< Invalid Enemies Constructor >>", en.speed(), 3, 0.01 );
        assertNotNull( "<< Invalid Enemies Constructor >>", en.getImage() );
    }


    @Test
    public void enemiesOffScreen()
    {
        en.offScreen();
        assertFalse( "<< onScreen should be false >>", en.exists() );
    }


    @Test
    public void enemiesSetSpeed()
    {
        en.setSpeed( 35 );
        assertEquals( "<< Speed should be 35 >>", 35, en.speed(), 0.01 );
    }


    @Test
    public void enemiesSetX()
    {
        en.setX( 35 );
        assertEquals( "<< X should be 35 >>", 35, en.getX(), 0.01 );
    }


    @Test
    public void enemiesSetY()
    {
        en.setY( 35 );
        assertEquals( "<< Y should be 35 >>", 35, en.getY(), 0.01 );
    }

    // GoogleSheets
    /**
     * GoogleSheets tests:
     * 
     * GoogleSheetsConstructor - checks to make sure fields are correct
     * GoogleSheetsUpdate - checks to make sure object moves
     * GoogleSheetsToString - checks toString method
     * 
     */

    /**
     * GoogleSheets Class
     */
    private GoogleSheets gs = new GoogleSheets( "/Resources/Sprites/Enemies/googlesheets.png", 30, 160, 3 );


    @Test
    public void googleSheetsConstructor()
    {
        assertEquals( "<< Invalid GoogleSheets Constructor >>", gs.getX(), 30, 0.01 );
        assertEquals( "<< Invalid GoogleSheets Constructor >>", gs.getY(), 160, 0.01 );
        assertEquals( "<< Invalid GoogleSheets Constructor >>", gs.speed(), 3, 0.01 );
        assertNotNull( "<< Invalid GoogleSheets Constructor >>", gs.getImage() );
    }


    @Test
    public void googleSheetsUpdate()
    {
        gs.setX( 0 );
        double newX = gs.getX() - gs.speed();
        gs.update();
        assertEquals( "<< X should be " + newX + " >>", newX, gs.getX(), 0.01 );
        assertFalse( "<< onScreen should be false >>", gs.exists() );
    }


    @Test
    public void googleSheetsToString()
    {
        assertEquals( "<< ToString should be GoogleSheets >>", "GoogleSheets", gs.toString() );
    }

    // WebCat

    /**
     * WebCat tests:
     * 
     * WebCatConstructor - checks to make sure fields are correct WebCatUpdate -
     * moves object and varies in velocity WebCatToString - checks toString
     * method
     * 
     */

    /**
     * WebCat Class
     */
    private WebCat wc = new WebCat( "/Resources/Sprites/Enemies/webcat.png", 30, 160, 3 );


    @Test
    public void webCatConstructor()
    {
        assertEquals( "<< Invalid WebCat Constructor >>", wc.getX(), 30, 0.01 );
        assertEquals( "<< Invalid WebCat Constructor >>", wc.getY(), 160, 0.01 );
        assertEquals( "<< Invalid WebCat Constructor >>", wc.speed(), 3, 0.01 );
        assertNotNull( "<< Invalid WebCat Constructor >>", wc.getImage() );
        assertTrue( "<< Invalid WebCat Constructor >>", wc.ground() );
    }


    @Test
    public void webCatUpdate()
    {
        wc.setX( 0 );
        double newX = wc.getX() - wc.speed();
        wc.update();
        assertEquals( "<< X should be " + newX + " >>", newX, wc.getX(), 0.01 );
        assertEquals( "<< Y should be " + wc.getY() + " >>", wc.getY(), 160, 0.01 );
        assertEquals( "<< VelocityY should be " + wc.getGravity() + " >>", wc.getGravity(),
            wc.getGravity(), 0.01 );
        assertFalse( "<< onScreen should be false >>", wc.exists() );
        wc.setY( 170 );
        wc.update();
        assertEquals( "<< Y should be " + wc.getY() + " >>", wc.getY(), 160, 0.01 );
        assertTrue( "<< VelocityY should be in between -8 and 0 >>", wc.getVelocityY() > -8
            && wc.getVelocityY() < 0 );
        assertFalse( "<< onGround should be false >>", wc.ground() );
    }


    @Test
    public void webCatToString()
    {
        assertEquals( "<< ToString should be WebCat >>", "WebCat", wc.toString() );
    }

    // Spawner
    /**
     * Spawner tests:
     * 
     * SpawnerConstructor - checks to make sure fields are correct
     * SpawnerRemoveAll - removes all enemies SpawnerUpdate - makes sure player
     * loses when in contact SpawnerSetSpeeds - changes speed of enemies
     * 
     */

    /**
     * GoogleSheets Class (Second one)
     */
    private GoogleSheets gs1 = new GoogleSheets( "/Resources/Sprites/Enemies/googlesheets.png",
        100, 160, 3 );

    /**
     * WebCat Class (Second one)
     */
    private WebCat wc1 = new WebCat( "/Resources/Sprites/Enemies/webcat.png", 100, 160, 3 );


    @Test
    public void spawnerConstructor()
    {
        assertNotNull( "<< Invalid Spawner Constructor >>", s.getSpawn() );
        assertEquals( "<< Invalid Spawner Constructor >>", 40, s.getRate() );
        assertFalse( "<< Invalid Spawner Constructor >>", s.gameOver() );
        assertNotNull( "<< Invalid Spawner Constructor >>", s.getMain() );
    }


    @Test
    public void spawnerRemoveAll()
    {
        s.getSpawn().add( gs1 );
        assertFalse( "<< Spawner should not be empty >>", s.isEmpty() );
        s.removeAll();
        assertTrue( "<< Spawner should be empty >>", s.isEmpty() );
    }


    @Test
    public void spawnerUpdate()
    {
        s.getSpawn().add( gs1 );
        gs1.offScreen();
        s.update();
        assertTrue( "<< GameOver should be true >>", s.gameOver() );
        assertTrue( "<< Spawner should be empty >>", s.isEmpty() );
        s.setGameOver( false );
        s.getSpawn().add( wc1 );
        s.update();
        assertTrue( "<< GameOver should be true >>", s.gameOver() );
        s.setRate( 0 );
        s.setCount( 40 );
        s.update();
        assertEquals( "<< Count should be 1 >>", 1, s.getCount() );
        assertEquals( "<< Size should be 2 >>", 2, s.getSize() );
    }


    @Test
    public void spawnerSetSpeeds()
    {
        s.setSpeeds( 1, 2 );
        assertEquals( "<< webSpd should be 1", 1, s.getWeb() );
        assertEquals( "<< googSpd should be 2", 2, s.getGoog() );
    }

    // PowersSpawner

    /**
     * PowersSpawner tests:
     * 
     * PowersSpawnerConstructor - checks to make sure fields are correct
     * PowersSpawnerUpdate - spawns power-ups at a random rate
     * 
     */

    /**
     * PowersSpawner Class
     */
    private PowersSpawner ps = new PowersSpawner( m, bg1, s );


    @Test
    public void powersSpawnerConstructor()
    {
        assertNotNull( "<< Invalid PowersSpawner Constructor >>", ps.getSpawn() );
        assertNotNull( "<< Invalid PowersSpawner Constructor >>", ps.getBack() );
        assertNotNull( "<< Invalid PowersSpawner Constructor >>", ps.getSpawner() );
        assertEquals( "<< Invalid PowersSpawner Constructor >>", 40, ps.getRate() );
        assertNotNull( "<< Invalid PowersSpawner Constructor >>", ps.getMain() );
    }


    @Test
    public void powersSpawnerUpdate()
    {
        db = new DropBox( "/Resources/Sprites/dropbox.png", 600, 25, m, bg1, s );
        s = new Spawner( m );
        ps = new PowersSpawner( m, bg1, s );
        db.setShowImage( false );
        ps.getSpawn().add( db );
        ps.update();
        assertEquals( "<< Count should be 1 >>", 1, db.getCount(), 0.01 );
        assertTrue( " << Spawn size should be 0 >>", ps.getSpawn().isEmpty() );
        ps.setCount( 160 );
        ps.setRate( 0 );
        ps.update();
        assertEquals( "<< Count should be 1 >>", ps.getCount(), 1, 0.01 );
        assertEquals( "<< Spawn size should be 1 >>", 1, ps.getSpawn().size(), 0.01 );
        assertEquals( "<< Rate should be 500 >>", ps.getRate(), 500, 0.01 );
    }


    // MainCharacter

    /**
     * MainCharacter tests:
     * 
     * MainCharacterConstructor - checks to make sure fields are correct
     * MainCharacterSetTime - sets time MainCharacterSetPosition - sets x and y
     * position MainCharacterSetAnimation - sets animation speed
     * MainCharacterUpdate - lets user control player
     * MainCharacterOnJumpKeyPressed - velocity for jumping
     * MainCharacterKeyPressed - if user presses jump key
     * 
     */

    @Test
    public void mainCharacterConstructor()
    {
        m = new MainCharacter( "/Resources/Sprites/Player/standing.png", 100, 160 );
        assertEquals( "<< Invalid MainCharacter Constructor >>", 6, m.getAnimation() );
        assertEquals( "<< Invalid MainCharacter Constructor >>", 0, m.getCount(), 0.01 );
        assertFalse( "<< Invalid MainCharacter Constructor >>", m.getJumped() );
        assertFalse( "<< Invalid MainCharacter Constructor >>", m.getGround() );
        assertNotNull( "<< Invalid MainCharacter Constructor >>", m.getImage() );
    }


    @Test
    public void mainCharacterSetTime()
    {
        m.setTime( 25 );
        assertEquals( "<< Time should be 25 >>", 25, m.getTime(), 0.01 );
    }


    @Test
    public void mainCharacterSetPosition()
    {
        m.setPosition( 30, 5 );
        assertEquals( "<< X should be 30 >>", 30, m.getX(), 0.01 );
        assertEquals( "<< Y should be 5 >>", 5, m.getY(), 0.01 );
    }


    @Test
    public void mainCharacterSetAnimation()
    {
        m.setAnimation( 35 );
        assertEquals( "<< Speed should be 35 >>", 35, m.getAnimation() );
    }


    @Test
    public void mainCharacterUpdate()
    {
        m.setGround( true );
        m.setCount( 71 );
        m.setVelocities( 1, 2 );
        m.setTime( 3 );
        m.setY( 50 );
        m.update();
        assertEquals( "<< Count should be 1 >>", 1, m.getCount(), 0.01 );
        assertEquals( "<< Y should be 56 >>", 56, m.getY(), 0.01 );
        assertEquals( "<< Animation should be " + 2 + 3 * m.getGravity() + " >>",
            2 + 3 * m.getGravity(),
            m.getVelocityY(),
            0.01 );

        m.setY( 160 );
        m.setGround( false );
        m.update();
        assertEquals( "<< Y should be 160", 160, m.getY(), 0.01 );
        assertEquals( "<< VelocityY should be 0", 0, m.getVelocityY(), 0.01 );
        assertTrue( "<< onGround should be true", m.getGround() );
    }


    @Test
    public void mainCharacterOnJumpKeyPressed()
    {
        m.setGround( true );
        m.OnJumpKeyPressed();
        assertEquals( "<< VelocityY should be -12f >>", -12f, m.getVelocityY(), 0.01 );
        assertFalse( "<< onGround should be false", m.getGround() );
    }


    @Test
    public void mainCharacterKeyPressed()
    {
        m.setJumped( false );
        m.keyPressed( KeyEvent.VK_SPACE );
        assertTrue( "<< jumped should be true >>", m.getJumped() );

    }
    // SlowDown

    /**
     * SlowDown tests:
     * 
     * SlowDownConstructor - checks to make sure fields are correct
     * SlowDownSetVector - sets vector of power-up SlowDownUpdate - checks to
     * make sure object is moving SlowDownDraw - changes character/enemy speed
     * SlowDownSlow - slows down enemy depending on type
     * 
     */

    /**
     * SlowDown Class
     */
    private SlowDown sd = new SlowDown( "/Resources/Sprites/github.png", 600, 25, m, bg1, s );


    @Test
    public void slowDownConstructor()
    {
        assertEquals( "<< Invalid SlowDown Constructor >>", sd.getCount(), 0 );
        assertFalse( "<< Invalid SlowDown Constructor >>", sd.exists() );
        assertEquals( "<< Invalid SlowDown Constructor >>", sd.getX(), 600, 0.01 );
        assertEquals( "<< Invalid SlowDown Constructor >>", sd.getY(), 25, 0.01 );
        assertNotNull( "<< Invalid SlowDown Constructor >>", sd.getImage() );
        assertNotNull( "<< Invalid SlowDown Constructor >>", sd.getSpawner() );
        assertNotNull( "<< Invalid SlowDown Constructor >>", sd.getMain() );
        assertNotNull( "<< Invalid SlowDown Constructor >>", sd.getBack() );
    }


    @Test
    public void slowDownSetVector()
    {
        sd.setVector( 25, 30 );
        assertEquals( "<< VelocityX should be 25 >>", 25, sd.getDX(), 0.01 );
        assertEquals( "<< VelocityY should be 30 >>", 30, sd.getDY(), 0.01 );
    }


    @Test
    public void slowDownUpdate()
    {
        sd.setExists( true );
        sd.update();
        assertEquals( "<< VelocityX should be -3 >>", -3, sd.getDX(), 0.01 );
        assertEquals( "<< VelocityY should be 0 >>", 0, sd.getDY(), 0.01 );
        assertEquals( "<< X should be 597 >>", 597, sd.getX(), 0.01 );
        sd.setCount( 350 );
        sd.getSpawner().getSpawn().add( wc );
        sd.getSpawner().getSpawn().add( gs );
        sd.update();
        assertEquals( "<< Background vector should be -3 >>", -3, bg1.getVector(), 0.01 );
        assertEquals( "<< VectorX should be -2 >>", -2, sd.getDX(), 0.01 );
        assertEquals( "<< Main animation should be 6 >>", 6, m.getAnimation() );
        assertEquals( "<< Count should be 1 >>", 1, sd.getCount() );
        assertEquals( "<< X should be 800 >>", sd.getX(), 800, 0.01 );
        assertEquals( "<< Main Time should be 1 >>", m.getTime(), 1, 0.01 );
        assertEquals( "<< WebCat speed should be 4 >>", 4, wc.speed(), 0.01 );
        assertEquals( "<< GoogleSheets speed should be 3 >>", 3, gs.speed(), 0.01 );
        assertEquals( "<< Spawner WebCat speed should 4 >>", 4, s.getWeb() );
        assertEquals( "<< Spawner GoogleSheets speed should 3 >>", 3, s.getGoog() );
        assertFalse( "<< showImage should be false >>", sd.exists() );
    }


    @Test
    public void slowDownDraw()
    {
        sd.getSpawner().getSpawn().add( wc );
        sd.getSpawner().getSpawn().add( gs );
        m.setPosition( sd.getX(), sd.getY() );
        sd.draw( sd.getImage().createGraphics() );
        assertTrue( "<< showImage should be false >>", sd.exists() );
        assertEquals( "<< Back Vector should be -0.25 >>", -0.25, bg1.getVector(), 0.01 );
        assertEquals( "<< MainCharacter animation should be 30 >>", 30, m.getAnimation(),
            0.01 );
        assertEquals( "<< MainCharacter time should be 0.25 >>", 0.25, m.getTime(), 0.01 );
        assertEquals( "<< WebCat speed should be 2 >>", 2, wc.speed(), 0.01 );
        assertEquals( "<< GoogleSheets speed should be 1 >>", 1, gs.speed(), 0.01 );
        assertEquals( "<< Spawner WebCat speed should 2 >>", 2, s.getWeb() );
        assertEquals( "<< Spawner GoogleSheets speed should 1 >>", 1, s.getGoog() );
    }


    @Test
    public void slowDownSlow()
    {
        sd.slow( wc, 4, 3 );
        sd.slow( gs, 4, 3 );
        assertEquals( "<< Spawner WebCat speed should 4 >>", 4, s.getWeb() );
        assertEquals( "<< Spawner GoogleSheets speed should 3 >>", 3, s.getGoog() );
    }

    // GameOver

    /**
     * GameOver tests:
     * 
     * GameOverConstructor - checks to make sure fields are correct
     * GameOverSetScore - sets score GameOverKeyPressed - user controls the
     * option wanted
     * 
     */

    /**
     * GameStateManager class
     */
    GameStateManager gsm = new GameStateManager();

    /**
     * GameOver class
     */
    GameOver go = new GameOver( gsm );


    @Test
    public void gameOverConstructor()
    {
        assertNotNull( "<< Invalid GameOver Constructor >>", go.getGSM() );
        assertNotNull( "<< Invalid GameOver Constructor >>", go.getBack() );
        assertEquals( "<< Invalid GameOver Constructor >>", 0,
            go.getBack().getVectorX(), 0.01 );
        assertEquals( "<< Invalid GameOver Constructor >>", 1,
            go.getBack().getVectorY(), 0.01 );
        assertEquals( "<< Invalid GameOver Constructor >>", new Color( 64, 224, 208 ),
            go.getTitleColor() );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 28 ),
            go.getTitleFont() );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 75 ),
            go.getScoreFont() );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 12 ),
            go.getFont() );
    }


    @Test
    public void gameOverSetScore()
    {
        go.setScore( 35 );
        assertEquals( "<< Score should be 35", 35, go.getScore(), 0.01 );
    }


    @Test
    public void gameOverKeyPressed()
    {
        go.keyPressed( KeyEvent.VK_ENTER );
        assertEquals( "<< Gsm Lvl should be LevelOne(gsm) >>", new LevelOne( gsm ).toString(),
            gsm.lvl.toString() );
        assertEquals( "<< New GameState should be LevelOne >>",
            new LevelOne( gsm ).toString(),
            gsm.getStates().get( GameStateManager.LEVELONE ).toString() );
        assertEquals( "<< Gsm menu should be MenuState(gsm) >>", new MenuState( gsm ).toString(), 
            gsm.menu.toString() );
        assertEquals( "<< New GameState should be MenuState >>",
            new MenuState( gsm ).toString(),
            gsm.getStates().get( GameStateManager.MENUSTATE ).toString() );
        assertEquals( "<< CurrentState should be gsm.LEVELONE", GameStateManager.LEVELONE,
            gsm.getState() );
        go.setCurrentChoice( 1 );
        go.keyPressed( KeyEvent.VK_ENTER );
        assertEquals( "<< CurrentState should be gsm.MENUSTATE", GameStateManager.MENUSTATE,
            gsm.getState() );
        go.setCurrentChoice( 0 );
        go.keyPressed( KeyEvent.VK_UP );
        assertEquals( "<< CurrentChoice should be 2 >>", go.getChoice(), 2 );
        go.keyPressed( KeyEvent.VK_DOWN );
        assertEquals( "<< CurrentChoice should be 0 >>", go.getChoice(), 0 );
    }


    // GameStateManager

    /**
     * GameStateManager tests:
     * 
     * GameStateManagerConstructor - adds states to arraylist
     * GameStateManagerReset - re-instantiates state GameStateManagerSetState -
     * changes state GameStateManagerUpdate - updates score
     * 
     */

    @Test
    public void gameStateManagerConstructor()
    {
        gsm = new GameStateManager();
        assertNotNull( "<< Invalid GameStateManager Constructor >>", gsm.getStates() );
        assertNotNull( "<< Invalid GameStateManager Constructor >>", gsm.menu );
        assertNotNull( "<< Invalid GameStateManager Constructor >>", gsm.lvl );
        assertNotNull( "<< Invalid GameStateManager Constructor >>", gsm.over );
        assertNotNull( "<< Invalid GameStateManager Constructor >>", gsm.help );
        assertEquals( "<< Invalid GameStateManager Constructor >>", GameStateManager.MENUSTATE,
            gsm.getState() );
    }


    @Test
    public void gameStateManagerReset()
    {
        gsm.reset( GameStateManager.HELP, new HelpScreen( gsm ) );
        assertEquals( "<< Gsm HELP should be HelpScreen(gsm) >>",
            new HelpScreen( gsm ).toString(),
            gsm.help.toString() );
    }


    @Test
    public void gameStateManagerSetState()
    {
        gsm.setState( 3 );
        assertEquals( "<< CurrentChoice should be 3", 3, gsm.getState() );
    }


    @Test
    public void gameStateManagerUpdate()
    {
        gsm.lvl.setScore( 25 );
        gsm.update();
        assertEquals( "<< Scores should be equal >>", gsm.over.getScore(), gsm.lvl.getScore() );
    }

    // LevelOne

    /**
     * LevelOne tests:
     * 
     * LevelOneConstructor - checks to make sure fields are correct
     * LevelOneUpdate - determines if game finishes/tracks score LevelOneDraw -
     * changes screen if user jumps
     * 
     */

    /**
     * LevelOne Class
     */
    private LevelOne lo = new LevelOne( gsm );


    @Test
    public void levelOneConstructor()
    {
        assertNotNull( "<< Invalid LevelOne Constructor >>", lo.getGSM() );
        assertNotNull( "<< Invalid LevelOne Constructor >>", lo.getMain() );
        assertNotNull( "<< Invalid LevelOne Constructor >>", lo.getPowsSpawner() );
        assertNotNull( "<< Invalid LevelOne Constructor >>", lo.getSpawner() );
        assertNotNull( "<< Invalid LevelOne Constructor >>", lo.getBack() );
        assertEquals( "<< Invalid LevelOne Constructor >>", lo.getScore(), 0 );
        assertEquals( "<< Invalid LevelOne Constructor >>", lo.getCount(), 0 );
    }


    @Test
    public void levelOneUpdate()
    {
        lo.setCount( 14 );
        lo.getSpawner().setGameOver( true );
        lo.update();
        assertEquals( "<< Count should be 0 >>", lo.getCount(), 0 );
        assertEquals( "<< Score should be 1 >>", lo.getScore(), 1 );
        assertEquals( "<< State should be GameOver >>", GameStateManager.GAMEOVER, gsm.getState() );
    }


    @Test
    public void levelOneDraw()
    {
        lo.getMain().setJumped( true );
        lo.draw( lo.getMain().getImage().createGraphics() );
        assertFalse( "<< jumped should be false >>", lo.getMain().getJumped() );
    }

    // HelpScreen

    /**
     * HelpScreen tests:
     * 
     * HelpScreenConstructor - checks to make sure fields are correct
     * HelpScreenKeyPressed - determines what user wants to press (Enter to
     * exit)
     * 
     */

    /**
     * HelpScreen Class
     */
    private HelpScreen hs = new HelpScreen( gsm );


    @Test
    public void helpScreenConstructor()
    {
        assertNotNull( "<< Invalid GameOver Constructor >>", hs.getGSM() );
        assertNotNull( "<< Invalid GameOver Constructor >>", hs.getBack() );
        assertEquals( "<< Invalid GameOver Constructor >>", 0, hs.getBack().getVectorX(), 0.01 );
        assertEquals( "<< Invalid GameOver Constructor >>", 1, hs.getBack().getVectorY(), 0.01 );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 28 ),
            hs.getTitleFont() );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 12 ),
            hs.getFont() );
    }


    @Test
    public void helpScreenKeyPressed()
    {
        hs.keyPressed( KeyEvent.VK_ENTER );
        assertEquals( "<< CurrentChoice should be MenuState", GameStateManager.MENUSTATE,
            gsm.getState() );
    }

    // MenuState

    /**
     * MenuState tests:
     * 
     * MenuStateConstructor - checks to make sure fields are correct
     * MenuStateKeyPressed - user picks what state to go to/quit
     * 
     */

    /**
     * MenuState Class
     */
    private MenuState ms = new MenuState( gsm );


    @Test
    public void menuStateConstructor()
    {
        assertNotNull( "<< Invalid GameOver Constructor >>", ms.getGSM() );
        assertNotNull( "<< Invalid GameOver Constructor >>", ms.getBack() );
        assertEquals( "<< Invalid GameOver Constructor >>", 0, ms.getBack().getVectorX(), 0.01 );
        assertEquals( "<< Invalid GameOver Constructor >>", 1, ms.getBack().getVectorY(), 0.01 );
        assertEquals( "<< Invalid GameOver Constructor >>", new Color( 64, 224, 208 ), ms.getTitleColor() );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 28 ),
            ms.getTitleFont() );
        assertEquals( "<< Invalid GameOver Constructor >>", new Font( "Verdana", Font.BOLD, 12 ),
            ms.getFont() );
    }


    @Test
    public void menuStateKeyPressed()
    {
        ms.keyPressed( KeyEvent.VK_ENTER );
        assertEquals( "<< Gsm Lvl should be LevelOne(gsm) >>", new LevelOne( gsm ).toString(),
            gsm.lvl.toString() );
        assertEquals( "<< New GameState should be LevelOne >>",
            new LevelOne( gsm ).toString(),
            gsm.getStates().get( GameStateManager.LEVELONE ).toString() );
        assertEquals( "<< Gsm help should be HelpScreen(gsm) >>",
            new HelpScreen( gsm ).toString(),
            gsm.help.toString() );
        assertEquals( "<< New GameState should be HelpScreen >>",
            new HelpScreen( gsm ).toString(),
            gsm.getStates().get( GameStateManager.HELP ).toString() );
        assertEquals( "<< CurrentState should be gsm.LevelOne", GameStateManager.LEVELONE,
            gsm.getState() );
        ms.setCurrentChoice( 1 );
        ms.keyPressed( KeyEvent.VK_ENTER );
        assertEquals( "<< CurrentState should be gsm.Help", GameStateManager.HELP, gsm.getState() );
        ms.setCurrentChoice( 0 );
        ms.keyPressed( KeyEvent.VK_UP );
        assertEquals( "<< CurrentChoice should be 2 >>", ms.getChoice(), 2 );
        ms.keyPressed( KeyEvent.VK_DOWN );
        assertEquals( "<< CurrentChoice should be 0 >>", ms.getChoice(), 0 );
    }
}
