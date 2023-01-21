import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class test_stats here.
 * 
 * @Yuxin (your name) 
 * @version (a version number or a date)
 */
public class Test_stats extends World
{

    /**
     * Constructor for objects of class test_stats.
     * 
     */
    private Stats_Board the_Stats;
    private int time=120;
    public Test_stats()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        the_Stats=new Stats_Board();
        addObject(the_Stats, 300, 250);
    }
    public void act(){
        time--;
        if(time==0){
            the_Stats.addPoints("IQ", 1);
            the_Stats.addPoints("EQ", 1);
            the_Stats.addPoints("Creativity", 1);
            the_Stats.addPoints("Memory", 1);
            time=120;
        }
    }
}
