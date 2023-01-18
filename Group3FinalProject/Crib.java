import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crib extends World
{
    private GreenfootImage background = new GreenfootImage("crib.png");
    
    /**
     * Constructor for objects of class Crib.
     * 
     */
    public Crib()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);  
        setBackground(background);
        addObject(new Baby(), 824, 416);
    }
}
