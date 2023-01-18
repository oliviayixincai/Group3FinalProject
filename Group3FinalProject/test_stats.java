import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class test_stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test_stats extends World
{

    /**
     * Constructor for objects of class test_stats.
     * 
     */
    private Stat iq_stat;
    private Stat eq_stat;
    private Stat memory_stat;
    private Stat creativity_stat;
    private int[] stats_values=new int[4];
    private int count=30;
    public test_stats()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        iq_stat=new Stat("IQ", stats_values[0]);
        addObject(iq_stat, 100, 50);
        eq_stat=new Stat("EQ", stats_values[1]);
        addObject(eq_stat, 100, 100);
        memory_stat=new Stat("Memory", stats_values[2]);
        addObject(memory_stat, 100, 150);
        creativity_stat=new Stat("Creativity", stats_values[3]);
        addObject(creativity_stat, 100, 200);
    }
    public void act(){
        count--;
        if(count==0){
            for(int i=0; i<4; i++){
                stats_values[i]++;
            }
            iq_stat.setDisplayer(stats_values[0]);
            eq_stat.setDisplayer(stats_values[1]);
            memory_stat.setDisplayer(stats_values[2]);
            creativity_stat.setDisplayer(stats_values[3]);
            count=30;
        }
    }
}
