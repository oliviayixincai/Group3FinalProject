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
    }
    public void act(){
        if(display==false){
            findMax();
            find_job();
            display=true;
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
            job="game_developer";
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
}
