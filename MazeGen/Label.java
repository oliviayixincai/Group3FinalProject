import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Label extends Actor
{
    protected int value;
    protected static final Color transparent = new Color(0 , 0, 0, 0);
    protected Color border;
    
    public Label() {
        border = new Color(251, 239, 229);
    }
    
    /**
     * show initial value when label added to world
     */
    public void addedToWorld(World w) {
        setDisplay(value);
        updateImage();
    }
    
    /**
     * set new value of displayer and update appearance
     */
    public void setDisplay(int newValue) {
        value = newValue;
        updateImage();
    }
    
    /** 
     * return current value of label
     */
    public int getValue() {
        return value;
    }
    
    public abstract void updateImage();
    
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}