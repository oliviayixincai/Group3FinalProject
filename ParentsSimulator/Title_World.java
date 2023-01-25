import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the game title and homescreen along with a "Play" button to start the game.
 * 
 * @author Gloria Chan
 * @version: January 24, 2023
 * 
 * CREDIT: Background image from: https://www.pinterest.ca/pin/18366310973098552/
 * */
public class Title_World extends World
{
    private GreenfootImage titleBG;
    private GreenfootImage playImage = new GreenfootImage("playButton.png");
    private Button playButton;
    
    /**
     * Sets up the background image and adds a "Play" button.
     * 
     */
    public Title_World()
    {    
        super(1000, 700, 1); 
        titleBG = new GreenfootImage("titleScreenBG.png");
        setBackground(titleBG);
        playButton = new Button(playImage);
        addObject(playButton, 800, 600);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(playButton))
        {
            Greenfoot.setWorld(new Story_World());
        }
    }
}
