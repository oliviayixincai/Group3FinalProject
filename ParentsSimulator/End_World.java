import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.Arrays;
/**
 * Write a description of class End_World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End_World extends World
{
    private Player player;
    private UserInfo user;
    private int highScore;
    private String bestJob;
    private int score;
    
    private Map<String, Integer> stat_bars=new HashMap<String, Integer>();
    private int[] stats_values; 
    private String first;
    private String second;
    private String job;
    private boolean display=false;
    
    /**
     * Constructor for objects of class End_World.
     * 
     */
    public End_World(int[] stats)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        stat_bars.put("IQ", stats[0]);
        stat_bars.put("EQ", stats[1]);
        stat_bars.put("Memory", stats[2]);
        stat_bars.put("Creativity", stats[3]);
        stats_values=stats;
        Arrays.sort(stats_values);
        
        if (UserInfo.isStorageAvailable()) { // check if connected
            user = UserInfo.getMyInfo();
        }
        if (user != null){ // check if logged in
            highScore = user.getScore();
            bestJob = user.getString(1);
            //scoreBar.update("Welcome " + user.getUserName() + "! Don't Die! High score: " + highScore);

        } else {
            //scoreBar.update("Please Login to Play with full features!");
        }
    }
    
    public void act(){
        if(display==false){
            findMax();
            find_job();
            display=true;
        }
        if(Greenfoot.mouseClicked(this)){
            endGame();
        }
    }
    
    public void findMax(){
        for(String key: stat_bars.keySet()) {
            if(stat_bars.get(key)==stats_values[3]){
                first=key;
                stat_bars.remove(key);
                break;
            }
        }
        for(String k: stat_bars.keySet()) {
            if(stat_bars.get(k)==stats_values[2]){
                second=k;
                stat_bars.remove(k);
                break;
            }
        }
    }
    
    public void find_job(){
        if((first.equals("IQ")||second.equals("IQ"))&&(first.equals("EQ")||second.equals("EQ"))){
            job="doctor";
        }
        if((first.equals("IQ")||second.equals("IQ"))&&(first.equals("Creativity")||second.equals("Creativity"))){
            job="programmer";
        }
        if((first.equals("IQ")||second.equals("IQ"))&&(first.equals("Memory")||second.equals("Memory"))){
            job="lawyer";
        }
        if((first.equals("EQ")||second.equals("EQ"))&&(first.equals("Memory")||second.equals("Memory"))){
            job="teacher";
        }
        if((first.equals("EQ")||second.equals("EQ"))&&(first.equals("Creativity")||second.equals("Creativity"))){
            job="artist";
        }
        if((first.equals("Memory")||second.equals("Memory"))&&(first.equals("Creativity")||second.equals("Creativity"))){
            job="actor";
        }
        setBackground(new GreenfootImage(job+".png"));
    }
    
    public void stopped(){
        user.store();
    }
    
    //store user info
    private void endGame() {
        // calculate score by adding up all stats
        for(int i: stats_values){
            score += i;
        }

        if (score > highScore){
            highScore = score;
            bestJob = job;
        }
        //the kid's best job is the job with highest score
        if (user != null){
            user.setScore(highScore);
            user.setString(1, bestJob);
            user.store();
        }

        addObject (new ScoreBoard(720, 480), 512, 320);
        
        Greenfoot.stop();   
    }
}
