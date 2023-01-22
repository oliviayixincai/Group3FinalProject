import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Screens extends World
{
    protected Color transparent, border;
    
    /**
     * Constructor for objects of class Screens.
     * 
     */
    public Screens()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        setBackground("wood.png");
        transparent = new Color(0, 0, 0, 0);
        border = new Color(251, 239, 229);
    }
}
