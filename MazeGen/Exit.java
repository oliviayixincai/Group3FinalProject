import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Piece
{
    public Exit() {
        /*
        GreenfootImage i = new GreenfootImage(50, 50);
        i.setColor(Color.GREEN);
        i.fill();
        */
        GreenfootImage i = new GreenfootImage("bKing.png");
        setImage(i);
    }
    
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(Player.class)) {
            WinScreen newW = new WinScreen();
            //Greenfoot.removeWorld();
            Greenfoot.setWorld(newW);
        }
    }
}
