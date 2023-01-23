import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends Screens
{
    private int points, timeTaken;
    private boolean won;
    private MainWorld mainWorld;
    
    private GreenfootSound chessFail;
    
    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen(int points, int timeTaken, boolean won, MainWorld mainWorld) {    
        super();
        getBackground().drawImage(new GreenfootImage("yay.png"), 250, 175);
        // image from https://learningworksforkids.com/vector-illustration-of-retro-pastel-color-smile-pink-brain-with-2/
        
        this.points = points;
        this.timeTaken = timeTaken;
        this.won = won;
        this.mainWorld = mainWorld;
        
        chessFail = new GreenfootSound("chessFail.wav");
        
        GreenfootImage pDisplay = new GreenfootImage("You get " + points + " points", 50, border, transparent);
        
        if(won) {
            Constants.successSound.play();
            GreenfootImage win = new GreenfootImage("Congratulations! \nYou finished the game in " + timeTaken + " seconds!", 50, border, transparent);
            getBackground().drawImage(win, 100, 50);
        } else {
            chessFail.play();
            GreenfootImage lose = new GreenfootImage("Oops! Time is up!", 50, border, transparent);
            getBackground().drawImage(lose, 315, 75);
        }
        getBackground().drawImage(pDisplay, 320, 575);
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            this.mainWorld.addPoint("IQ", points/2);
            this.mainWorld.addPoint("Creativity", points/2);
            Constants.chessSound.stop();
            Greenfoot.setWorld(mainWorld);
            Constants.backgroundSound.playLoop();
        }
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