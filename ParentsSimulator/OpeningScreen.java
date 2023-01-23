import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpeningScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningScreen extends Screens
{
    private MainWorld mainWorld;
    
    /**
     * Constructor for objects of class OpeningScreen.
     * 
     */
    public OpeningScreen(MainWorld main) {
        super();
        mainWorld = main;
        
        GreenfootImage first = new GreenfootImage("Capture the king to win the game!", 60, border, transparent);
        GreenfootImage second = new GreenfootImage("Navigate using WASD or arrow keys \nto set your direction.", 50, border, transparent);
        GreenfootImage third = new GreenfootImage("Be careful not to fall off the board!", 50, border, transparent);
        getBackground().drawImage(first, 60, 75);
        getBackground().drawImage(second, 115, 175);
        getBackground().drawImage(third, 125, 450);

        //GreenfootImage king1 = GreenfootImage(new GreenfootImage("wKing.png").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
        
        GreenfootImage king1 = new GreenfootImage("wKing.png");
        king1.scale(70, 70);
        getBackground().drawImage(king1, 250, 325);
        
        GreenfootImage king2 = new GreenfootImage("bKing.png");
        king2.scale(70, 70);
        getBackground().drawImage(king2, 725, 325);
        
        GreenfootImage arrow = new GreenfootImage("arrow.png");
        getBackground().drawImage(arrow, 350, 325);
        // img from https://www.twinkl.it/illustration/hand-drawn-arrow-straight-general-secondary-bw-rgb
        
        GreenfootImage fourth = new GreenfootImage("Click to begin", 60, border, transparent);
        getBackground().drawImage(fourth, 340, 550);
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Chessboard(mainWorld));
        }
    }
}
