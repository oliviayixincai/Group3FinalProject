import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AbstractWorld here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public abstract class AbstractWorld extends World {
    protected MainWorld mainWorld;
    
    /**
     * Constructor for objects of class AbstractWorld.
     * 
     */
    public AbstractWorld(MainWorld mainWorld) {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        this.mainWorld = mainWorld;
    }
}
