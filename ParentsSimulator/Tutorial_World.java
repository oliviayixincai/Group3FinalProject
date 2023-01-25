import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Teaches the user everything about the game (and the story behind it).
 * 
 * @author: Gloria Chan
 * @version: January 23, 2023
 * 
 * CREDIT: Yuxin's Story_World for reference.
 */
public class Tutorial_World extends World
{
    private GreenfootImage[] tutorialPage = new GreenfootImage[13];
    private int pageNumber;
    
    private GreenfootImage proceedMessage;
    private Flashing_Text flashingMessage;
    
    /**
     * For every page, there is a corresponding image. The user will be prompted to proceed to
     * the next page by clicking on anywhere on the screen.
     * 
     */
    public Tutorial_World()
    {    
        super(1000, 700, 1); 
        proceedMessage = new GreenfootImage("proceed.png");
        
        flashingMessage = new Flashing_Text(proceedMessage);
        addObject(flashingMessage, 500, 630);
        
        pageNumber = 0;
        for(int i = 1; i <= 12; i++){
            tutorialPage[i-1]=new GreenfootImage("tutorialPg"+ i +".png");
        }
        setBackground(tutorialPage[pageNumber]);
    }
    
    public void act()
    {
        // The user proceeds to the next page everytime the screen is clicked.
        if (Greenfoot.mouseClicked(null))
        {
            pageNumber++;
            setBackground(tutorialPage[pageNumber]);
            if (pageNumber == 12)
            {
                Greenfoot.setWorld(new MainWorld());
            }
        }
    }
}
