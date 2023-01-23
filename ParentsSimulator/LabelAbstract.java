import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Time_Label here.
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 */
public abstract class LabelAbstract extends Actor
{
    
    protected int value;
    protected static final Color transparent = new Color(0,0,0,0);
    protected Color border;
    /**
     * Store the initial value of the label 
     * @param value Initial value of the label
     */
    public LabelAbstract(){
        border = new Color(251, 239, 229);
    }
    
    /**
     * when the label is added to world, show the initial value
     */
    public void addedToWorld(World w){
        setDisplayer(value);
        updateImage();
    }
    
    /**
     * set the new value of displayer and update the displayer
     * @param newValue new value of value 
     */
    public void setDisplayer(int newValue)
    {
        value = newValue;
        updateImage();
    }
    
    /**
     * return the current value of label
     */
    public int getValue() {
        return value;
    }
    
    public abstract void updateImage();
    
}