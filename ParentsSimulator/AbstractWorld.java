import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an abstract world for the world need main world as a parameter.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public abstract class AbstractWorld extends World {
    // declare the object
    protected MainWorld mainWorld;
    
    /**
     * Constructor for objects of class AbstractWorld.
     * @param mainWorld It is a MainWorld for the other worlds to use
     */
    public AbstractWorld(MainWorld mainWorld) {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        // initialize the object
        this.mainWorld = mainWorld;
        // play the music once the constructor is initialized.
        Constants.backgroundSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.backgroundSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.backgroundSound.pause();
    }
}
