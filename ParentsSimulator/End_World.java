import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.Arrays;
/**
 * EndWorld finds out the correlated outcome for each child based on the highest two stats. It stores the 
 * highest user history and display it on the user board 
 * 
 * @Yuxin Li 
 * @Jan 2023 
 */
public class End_World extends World
{
    private Player player;
    private UserInfo user;
    private int highScore;
    private String bestJob;
    private int score;
    private boolean showBoard=false;
    
    private Map<String, Integer> stat_bars=new HashMap<String, Integer>();
    private int[] stats_values; 
    private String first;
    private String second;
    private String job;
    private boolean display=false;
    
    private Flashing_Text endText;
    private GreenfootImage text1, text2, text3;
    private Color transparent;
    /**
     * Constructor for objects of class End_World. Get the user info and store the stats in the 
     * instance variables
     * 
     */
    public End_World(int[] stats)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        transparent = new Color(0,0,0,0);
        stat_bars.put("IQ", stats[0]);
        stat_bars.put("EQ", stats[1]);
        stat_bars.put("Memory", stats[2]);
        stat_bars.put("Creativity", stats[3]);
        stats_values=stats;
        Arrays.sort(stats_values);
        
        endText=new Flashing_Text(new GreenfootImage("endInstruction.png"));
        addObject(endText, 512, 630);
        if (UserInfo.isStorageAvailable()) { // check if connected
            user = UserInfo.getMyInfo();
        }
        if (user != null){ // check if logged in
            highScore = user.getScore();
            bestJob = user.getString(1);
        } 
    }
    
    public void act(){
        if(display==false){
            findMax();
            find_job();
            display=true;
        }
        if((Greenfoot.mouseClicked(this)||Greenfoot.mouseClicked(endText))&&showBoard==false){
            endGame();
        }
    }
    
    /**
     * find the highest two stats
     */
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

    /**
     * find the correlated job of the child based on the highest two stats and displays the image and story
     */
    public void find_job(){
        GreenfootImage text3 = new GreenfootImage("You must be a very proud parent :)", 60, Color.BLACK, transparent);
        if((first.equals("IQ")||second.equals("IQ"))&&(first.equals("EQ")||second.equals("EQ"))){
            job="doctor";
            setBackground(new GreenfootImage(job+".png"));
            text1 = new GreenfootImage("After high school, \nyour child applied to medical school \nand worked hard to help others as a", 50, Color.BLACK, transparent);
            text2 = new GreenfootImage("doctor!", 150, Color.BLACK, transparent);
            getBackground().drawImage(text1, 100, 100);
            getBackground().drawImage(text2, 275, 275);
        }
        if((first.equals("IQ")||second.equals("IQ"))&&(first.equals("Creativity")||second.equals("Creativity"))){
            job="programmer";
            setBackground(new GreenfootImage(job+".png"));
            text1 = new GreenfootImage("After high school, \nyour child improved their computer skills \nand was hired as a ", 50, Color.BLACK, transparent);
            text2 = new GreenfootImage("programmer!", 150, Color.BLACK, transparent);
            getBackground().drawImage(text1, 60, 125);
            getBackground().drawImage(text2, 85, 275);
        }
        if((first.equals("IQ")||second.equals("IQ"))&&(first.equals("Memory")||second.equals("Memory"))){
            job="lawyer";
            setBackground(new GreenfootImage(job+".png"));
            text1 = new GreenfootImage("After high school, \nyour child studied hard for a law degree \nand passed the exam to become a", 50, Color.BLACK, transparent);
            text2 = new GreenfootImage("lawyer!", 150, Color.BLACK, transparent);
            getBackground().drawImage(text1, 75, 100);
            getBackground().drawImage(text2, 275, 275);
        }
        if((first.equals("EQ")||second.equals("EQ"))&&(first.equals("Memory")||second.equals("Memory"))){
            job="teacher";
            setBackground(new GreenfootImage(job+".png"));
            text1 = new GreenfootImage("After high school, \nyour child fulfilled their dream of \nhelping teach others as a ", 50, Color.BLACK, transparent);
            text2 = new GreenfootImage("teacher!", 150, Color.BLACK, transparent);
            getBackground().drawImage(text1, 150, 115);
            getBackground().drawImage(text2, 255, 300);
        }
        if((first.equals("EQ")||second.equals("EQ"))&&(first.equals("Creativity")||second.equals("Creativity"))){
            job="artist";
            setBackground(new GreenfootImage(job+".png"));
            text1 = new GreenfootImage("After high school, \nyour child went on to fill displays and\nexhibits for their work as a ", 50, Color.BLACK, transparent);
            text2 = new GreenfootImage("artist!", 150, Color.BLACK, transparent);
            getBackground().drawImage(text1, 100, 100);
            getBackground().drawImage(text2, 300, 275);
        }
        if((first.equals("Memory")||second.equals("Memory"))&&(first.equals("Creativity")||second.equals("Creativity"))){
            job="actor";
            setBackground(new GreenfootImage(job+".png"));
            text1 = new GreenfootImage("After high school, \nyour child practiced their acting skills \nand moved to Hollywood to be an", 50, Color.BLACK, transparent);
            text2 = new GreenfootImage("actor!", 150, Color.BLACK, transparent);
            getBackground().drawImage(text1, 100, 125);
            getBackground().drawImage(text2, 325, 300);
        }
        getBackground().drawImage(text3, 75, 500);
    }
    
    /**
     * calculate the user info and compare the new result and the history result, show the user result board
     */
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
        showBoard=true;
        user.store();
        
    }
}
