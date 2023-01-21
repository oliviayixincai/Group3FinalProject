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
    
    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen(int points, int timeTaken, boolean won, MainWorld mainWorld) {    
        super();
        setBackground("wood.png");
        getBackground().drawImage(new GreenfootImage("yay.png"), 250, 175);
        // image from https://learningworksforkids.com/vector-illustration-of-retro-pastel-color-smile-pink-brain-with-2/
        
        this.points = points;
        this.timeTaken = timeTaken;
        this.won = won;
        this.mainWorld = mainWorld;
        
        GreenfootImage pDisplay = new GreenfootImage("You get " + points + " points", 50, border, transparent);
        
        if(won) {
            GreenfootImage win = new GreenfootImage("Congratulations! \nYou finished the game in " + timeTaken + " seconds!", 50, border, transparent);
            getBackground().drawImage(win, 100, 50);
        } else {
            GreenfootImage lose = new GreenfootImage("Oops! Time is up!", 50, border, transparent);
            getBackground().drawImage(lose, 315, 75);
        }
        getBackground().drawImage(pDisplay, 320, 575);
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            Stats_Board stats = mainWorld.returnStats();
            stats.addPoints("IQ", points/2);
            stats.addPoints("Creativity", points/2);
            Greenfoot.setWorld(mainWorld);
        }
    }
}