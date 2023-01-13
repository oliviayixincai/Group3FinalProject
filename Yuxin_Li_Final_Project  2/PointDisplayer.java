import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PointDisplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PointDisplayer extends Label
{
    /**
     * Act - do whatever the PointDisplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PointDisplayer(int value){
        this.value=value;
    }
    
    public void updateImage()
    {
        //display number for displayer
        GreenfootImage display = new GreenfootImage("Total Points: "+ getValue(), 50, Color.BLACK, transparent);
        setImage(display);
    }
}
