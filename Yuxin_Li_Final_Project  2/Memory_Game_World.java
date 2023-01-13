import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * https://www.pinterest.ca/pin/587367976379616134/
 */
public class Memory_Game_World extends World
{
    
    private ArrayList<String> all_cards=new ArrayList<String>();
    private Card[][] cards;
    private int level;
    private int l_spacing=840/6;
    private int w_spacing=550/4;
    private Card first_card;
    private Card second_card;
    private int waittime;
    private TimeDisplayer timeDisplay=new TimeDisplayer(60);
    private PointDisplayer pointDisplay=new PointDisplayer(0);
    private long startTime;
    private long endTime;
    private int points;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Memory_Game_World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        for(int i=0; i<2; i++){
            all_cards.add("bunny");
            all_cards.add("cheetah");
            all_cards.add("elephant");
            all_cards.add("fox");
            all_cards.add("zebra");
            all_cards.add("bear");
            all_cards.add("chicken");
            all_cards.add("lion");
            all_cards.add("monkey");
            all_cards.add("panda");
            all_cards.add("sheep");
            all_cards.add("giraffe");
        }
        Collections.shuffle(all_cards);
        cards=new Card[4][6];
        int index=0;
        for(int i=0; i<cards.length; i++){
            for(int j=0; j<cards[i].length; j++){
                cards[i][j]=new Card(all_cards.get(index));
                index++;
                addObject(cards[i][j],150+j*l_spacing,150+i*w_spacing);
            }
        }
        waittime=30;
        addObject(timeDisplay, 200, 50);
        addObject(pointDisplay, 800, 50);
        startTime=System.nanoTime();
        points=0;
    }
    
    public void act(){
        first_card=Card.getFirst();
        second_card=Card.getSecond();
        if(first_card!=null&&second_card!=null){
            if((first_card.getName()).equals(second_card.getName())){
                countDown();
                if(waittime==0){
                    removeObject(first_card);
                    removeObject(second_card);
                    first_card=null;
                    second_card=null;
                    waittime=30;
                    Card.setUpNumber();
                    Card.setFirst();
                    Card.setSecond();
                    points++;
                }
            }
            else{
                countDown();
                if(waittime==0){
                    first_card.flipBack();
                    second_card.flipBack();
                    first_card=null;
                    second_card=null;
                    waittime=30;
                    Card.setUpNumber();
                    Card.setFirst();
                    Card.setSecond();
                } 
            }
            
        }
        if(90-getTimeInSeconds()>0){
            endTime=System.nanoTime();
            timeDisplay.setDisplayer(60-getTimeInSeconds());
        }
        pointDisplay.setDisplayer(points);
        if(points==12&&getTimeInSeconds()<60){
            Greenfoot.setWorld(new Game_Result_World(points, getTimeInSeconds(), true));
        }
        if(getTimeInSeconds()==60){
            Greenfoot.setWorld(new Game_Result_World(points, getTimeInSeconds(), false));
        }
    }
    public void countDown(){
        if(waittime>0){
            waittime--;
        }
    }
    public boolean finished(){
        if(getObjects(Card.class).size()==0){
            return true;
        }
        return false;
    }
    public int getTimeInSeconds ()
    {
        return (int)((double)(endTime - startTime) / 1000000000.0);
    }
}
