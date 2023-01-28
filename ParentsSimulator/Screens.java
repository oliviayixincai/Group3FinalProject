import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screens is an abstract superclass for the worlds in between the main game world and the chess minigame.
 * 
 * Original wood background from Vecteezy https://www.vecteezy.com/free-vector/cartoon-wood (has been edited)
 * 
 * @Fiona Ho
 * @version comment
 */
public abstract class Screens extends World
{
    protected Color transparent, border;
    
    /**
     * Constructor for objects of class Screens.
     * 
     */
    public Screens()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        setBackground("wood.png");
        transparent = new Color(0, 0, 0, 0);
        border = new Color(251, 239, 229);
        Constants.chessSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.chessSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.chessSound.pause();
    }
}
