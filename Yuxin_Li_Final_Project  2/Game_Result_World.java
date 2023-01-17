import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tell the player their score after finishing the flip card game
 * 
 * @Yuxin (your name) 
 * @version (a version number or a date)
 */
public class Game_Result_World extends World
{
    
    private int result_points;
    private int total_time;
    private boolean on_time;
    private Color transparent = new Color(0,0,0,0);
    /**
     * Constructor for objects of class Game_Result_World.
     * Check whether players get all the pairs in the game, and display
     * whether they finished the game or not.
     */
    public Game_Result_World(int points, int time_taken, boolean success)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        result_points=points;
        total_time=time_taken;
        on_time=success;
        
        if(on_time){
            GreenfootImage isSuccessful=new GreenfootImage("Congratulations! You finished the game in "+ total_time +" sec!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ points +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 200, 200);
            getBackground().drawImage(displayPoints, 320, 300);
        }
        else{
            GreenfootImage isSuccessful=new GreenfootImage("Oops! Time is up!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ points +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 400, 200);
            getBackground().drawImage(displayPoints, 320, 300);
        }
    }
    
}
