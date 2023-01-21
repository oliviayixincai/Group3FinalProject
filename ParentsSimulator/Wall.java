import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
