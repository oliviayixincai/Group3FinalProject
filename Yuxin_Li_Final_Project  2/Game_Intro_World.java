import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game_Intro_World here.
 * An Intro for the flip card intro world. Player can click to start 
 * playing the game.
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 */
public class Game_Intro_World extends World
{

    private GreenfootImage welcomeText;
    private Flashing_Text flashText;
    private GreenfootImage clickImage;
    /**
     * Intro World for the flip card game 
     * Add a Flashing text 
     */
    public Game_Intro_World()
    {    
        super(1024, 700, 1); 
        welcomeText=new GreenfootImage("memory_welcome_text.png");
        getBackground().drawImage(welcomeText, 125, 100);
        clickImage=new GreenfootImage("memory_clickText.png");
        flashText=new Flashing_Text(clickImage);
        addObject(flashText, 500, 600);
        
    }
    /**
     * click the screen to start game 
     */
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Memory_Game_World());
        }
    }
}
