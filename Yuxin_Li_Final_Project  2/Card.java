import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class card here.
 * 
 * @Yuxin (your name) 
 * @version (a version number or a date)
 * question mark: https://www.pinterest.com/pin/267542034093060703/
 */
public class Card extends Actor
{
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage animal;
    private static GreenfootImage cover=new GreenfootImage("card_cover.png");
    private String name;
    private boolean faceUp;
    private static int upNumber;
    private static Card first=null;
    private static Card second=null;
    public Card(String name){
        setImage(cover);
        animal=new GreenfootImage(name+".png");
        this.name=name;
        faceUp=true;
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)&&upNumber<2){
            setImage(animal);
            upNumber++;
            if(upNumber==1){
                first=this;
            }
            if(upNumber==2&&this!=first){
                second=this;
            }
            else if(upNumber==2&&this==first){
                upNumber=1;
            }
        }
        
    }
    public String getName(){
        return this.name;
    }
    public void flipBack(){
        setImage(cover);
    }
    public static int getUpNumber(){
        return upNumber;
    }
    public static void setUpNumber(){
        upNumber=0;
    }
    public static Card getFirst(){
        return first;
    }
    public static void setFirst(){
        first=null;
    }
    public static Card getSecond(){
        return second;
    }
    public static void setSecond(){
        second=null;
    }
}
