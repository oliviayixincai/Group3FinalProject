import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StoryWorld is an initial world that shows the player and intro story
 * of the game. Players can click the button to flip pages.
 * 
 * @Yuxin Li 
 * @version Jan 2023
 */

public class StoryWorld extends World
{
    private GreenfootImage[] backgrounds = new GreenfootImage[5];
    private GreenfootImage[] stories = new GreenfootImage[5];
    private int clickIndex;
    private Arrow forward;
    private Arrow backward;
    /**
     * Story World constructor
     * set the first page of story and add the flip page button
     */
    public StoryWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        for(int i=1; i<=5; i++){
            backgrounds[i-1]=new GreenfootImage("backgroundAlt"+i+".png");
            stories[i-1]=new GreenfootImage("page"+i+".png");
        }
        clickIndex=0;
        setBackground(backgrounds[clickIndex]);
        getBackground().drawImage(stories[clickIndex], 200, 530);
        forward=new Forward(this);
        addObject(forward, 920, 610);
        backward=new Backward(this);
        
        Constants.backgroundSound.playLoop();
    }
    
    public void act(){
        if(clickIndex>0){
            addObject(backward, 80, 610);
        }
        else {
            removeObject(backward);
        }
    }
    
    /**
     * get the current page number of story
     * @return int the current page number 
     */
    public int getClickIndex(){
        return clickIndex;
    }
    
    /**
     * set the page number 
     * @param num the page number
     */
    public void setClickIndex(int num){
        clickIndex=num;
    }
    
    /**
     * flip the story page by setting a new background and add the 
     * corresponding story
     */
    public void setStory(){
        setBackground(backgrounds[clickIndex]);
        getBackground().drawImage(stories[clickIndex], 200, 530);
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
