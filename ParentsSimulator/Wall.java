import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Wall is a subclass of Piece, where it can be detected by Player to block its movement.
 * 
 * @Fiona Ho 
 * @version comment
 */
public class Wall extends Piece
{
    public Wall() {
        GreenfootImage i = new GreenfootImage(50, 50);
        i.setColor(Color.RED);
        i.fill();
        setImage(i);
    }
    
    public void block() {
        if(isTouching(Player.class)) {
            
        }
    }
    
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
