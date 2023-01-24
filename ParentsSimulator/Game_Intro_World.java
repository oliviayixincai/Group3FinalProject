import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Introduction world to the flip card memory game, tell the player to click and start the game
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 * 
 * backgroundImage by Siti Fatona
 * <a href="https://www.vecteezy.com/free-vector/cute-background">Cute Background Vectors by Vecteezy</a>
 */
public class Game_Intro_World extends World
{

    
    private GreenfootImage background = new GreenfootImage("memory_intro.jpg");
    private GreenfootImage welcomeText;
    private Flashing_Text flashText;
    private GreenfootImage clickImage;
    private MainWorld main; 
    /**
     * Constructor for objects of class Game_Intro_World. Add a click to start flashtext.
     * If the world or the text is clicked, start the game.
     * 
     * @param mainWorld the main player world that the player will go back to after the game
     */
    public Game_Intro_World(MainWorld mainWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1);
        main=mainWorld;
        setBackground(background);
        welcomeText=new GreenfootImage("memory_welcome_text.png");
        getBackground().drawImage(welcomeText, 125, 100);
        clickImage=new GreenfootImage("memory_clickText.png");
        flashText=new Flashing_Text(clickImage);
        addObject(flashText, 500, 600);
        
        Constants.memorySound.playLoop();
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)||Greenfoot.mouseClicked(flashText)){
            Greenfoot.setWorld(new Memory_Game_World(main));
        }
    }
    
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.memorySound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.memorySound.pause();
    }
}
