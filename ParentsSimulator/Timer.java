import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the time left over in Chess game
 * 
 * @Fiona Ho
 * @version final
 */
public class Timer extends LabelAbstract
{
    public Timer(int value) {
        this.value = value;
    }
    
    public void updateImage() {
        GreenfootImage d = new GreenfootImage("Time Left: \n" + getValue(), 40, border, transparent);
        setImage(d);
    }
    
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
