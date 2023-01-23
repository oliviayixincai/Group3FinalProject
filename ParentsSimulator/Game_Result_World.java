import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The result world shows player whether they are successful in finishing the game or not. Tells the player how many points they earn
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 */
public class Game_Result_World extends World
{
    private String statAffected1;
    private String statAffected2;
    private int result_points;
    private int total_time;
    private boolean on_time;
    private Color transparent = new Color(0,0,0,0);
    private GreenfootImage background = new GreenfootImage("confetti.png");
    private MainWorld mainWorld;
    private int waitTime=60;
    /**
     * Show the player the results of the flip card game
     * @param points points earned by player
     * @param time_taken time used in the game
     * @param success whether the player remove all cards or not
     * @param mainWorld the main player world that the player will go back to after the game
     */
    public Game_Result_World(int points, int time_taken, boolean success, MainWorld mainWorld, String stat1, String stat2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        this.mainWorld=mainWorld;
        result_points=points;
        total_time=time_taken;
        on_time=success;
        statAffected1 = stat1;
        statAffected2 = stat2;
        
        setBackground(background);
        
        if(on_time){
            GreenfootImage isSuccessful=new GreenfootImage("Congratulations! You finished the game in "+ total_time +" sec!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ result_points +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 200, 150);
            getBackground().drawImage(displayPoints, 330, 200);
        }
        else{
            GreenfootImage isSuccessful=new GreenfootImage("Oops! Time is up!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ result_points +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 400, 150);
            getBackground().drawImage(displayPoints, 330, 200);
        }
    }
    public void act() {
        //go back to the main world and set the stats
        waitTime--;
        if (Greenfoot.mouseClicked(this)&&waitTime<=0) {
            this.mainWorld.addPoint(statAffected1, result_points/2);
            this.mainWorld.addPoint(statAffected2, result_points-result_points/2);
            Greenfoot.setWorld(mainWorld);
        }
    }
}
