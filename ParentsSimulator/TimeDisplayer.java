import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeDisplayer here.
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 */
public class TimeDisplayer extends LabelAbstract
{
    private int size;
    /**
     * Act - do whatever the TimeDisplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TimeDisplayer(int value){
        this(value, 50);
    }
    
    public TimeDisplayer(int value, int size){
        this.value = value;
        this.size = size;
    }
    public void updateImage()
    {
        //display number for displayer
        GreenfootImage display = new GreenfootImage("Time Left: "+ getValue() +" sec", this.size, Color.BLACK, transparent);
        setImage(display);
    }
}
