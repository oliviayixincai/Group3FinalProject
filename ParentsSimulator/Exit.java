import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Exit is a subclass of Piece, where it creates a WinScreen world if touched by a Player. It is the end of the maze in the Chessboard world.
 * 
 * @Fiona Ho
 * @version comment
 */
public class Exit extends Piece
{
    private Chessboard w;
    private MainWorld mainWorld;
    
    /**
     * Constructor for Exit.
     * 
     * @param mainWorld the main game world where the player returns after playing the chess minigame
     */
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
        if (isTouching(Player.class)) {
            Greenfoot.setWorld(new WinScreen(w.getPoints(), w.getTimeInSeconds(), true, mainWorld));
        }
    }
}
