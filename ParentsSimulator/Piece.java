import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for the maze parts of the chessboard
 * 
 * @Fiona Ho
 * @version final
 */
public class Piece extends Actor
{
    protected GreenfootImage i = new GreenfootImage(50,50);
    
    /**
     * Constructor for Piece
     */
    public Piece() {
        i = new GreenfootImage("path.png");
        //i.setColor(Color.GRAY);
        //i.fill();
        setImage(i);
    }
    
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
