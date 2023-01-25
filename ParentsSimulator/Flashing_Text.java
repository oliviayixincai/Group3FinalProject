import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Add a text image to create a blinking effect
 * 
 * @Yuxin Li  
 * @version Jan 2023
 */
public class Flashing_Text extends Actor
{
    private GreenfootImage textImage;
    private int time=3;
    private boolean flash=true;
    
    /**
     * constructor for the flashing_Text
     * @param text the text that will blink 
     */
    public Flashing_Text(GreenfootImage text){
        textImage=text;
        setImage(textImage);
    }
    
    public void act()
    {
        // Add your action code here.
        time--;
        int cur_transparency=getImage().getTransparency();
        if(flash){
            if(time==0){
                getImage().setTransparency(cur_transparency-=5);
                time=3;
            }
            if(getImage().getTransparency()==150){
                flash=false;
            }
        }
        else{
            if(time==0){
                getImage().setTransparency(cur_transparency+=5);
                time=3;
            }
            if(getImage().getTransparency()==255){
                flash=true;
            }
        }
    }
}
