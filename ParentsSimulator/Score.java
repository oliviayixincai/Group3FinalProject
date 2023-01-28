import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Score is a class that displays the points that will be won in Chess game if completed at that point, using methods from the LabelAbstract class
 * 
 * @Fiona Ho
 * @version comment
 */
public class Score extends LabelAbstract
{
    public Score(int value) {
        this.value = value;
    }
    
    public void updateImage() {
        GreenfootImage d = new GreenfootImage("Total Points: \n" + getValue(), 40, border, transparent);
        setImage(d);
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
