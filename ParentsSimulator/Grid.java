import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid extends Actor
{
    public Grid() {
        GreenfootImage grid = new GreenfootImage(1000, 700);
        int x1 = 410;
        int y1 = 215;
        int x2 = 890;
        int y2 = 485;
        int height = 90;
        int width = 120;
        for (int i = 0; i < (y2 - y1) / height + 1; i++) {
            grid.drawLine(x1, y1 + i * height, x2, y1 + i * height);
        }
        for (int i = 0; i < (x2 - x1) / width + 1; i++) {
            grid.drawLine(x1 + i * 120, y1, x1 + i * 120, y2);
        }
        setImage(grid);
    }
    /**
     * Act - do whatever the Grid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
