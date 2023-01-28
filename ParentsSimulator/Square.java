import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns a visual chessboard in black/white squares
 * 
 * Square pngs by Fiona
 * 
 * @Fiona Ho
 * @version final
 */
public class Square extends Actor
{
    private GreenfootImage square;
    
    /**
     * Constructor for the chessboard squares
     * 
     * @param color the color of the square
     */
    public Square(String color) {
        //GreenfootImage square = new GreenfootImage(75, 75);
        if(color.equals("W")) {
            //square.setColor(Color.WHITE);
            square = new GreenfootImage("wSquare.png");
        } else if(color.equals("B")) {
            //square.setColor(Color.BLACK);
            square = new GreenfootImage("bSquare.png");
        }
        //square.fill();
        setImage(square);
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
