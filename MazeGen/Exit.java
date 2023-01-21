import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Piece
{
    private Chessboard w;
    private MainWorld mainWorld;
    
    public Exit(MainWorld main) {
        /*
        GreenfootImage i = new GreenfootImage(50, 50);
        i.setColor(Color.GREEN);
        i.fill();
        */
        GreenfootImage i = new GreenfootImage("bKing.png");
        setImage(i);
        mainWorld = main;
    }
    
    public void addedToWorld(World w){
        this.w = (Chessboard)w;
    }
    
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getOneIntersectingObject(Player.class) != null && getOneIntersectingObject(Exit.class) != null) {
            Greenfoot.setWorld(new WinScreen(w.getPoints(), w.getTimeInSeconds(), true, mainWorld));
        }
    }
}
