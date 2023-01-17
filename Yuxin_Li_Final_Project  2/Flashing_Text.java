import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flashing_Text here.
 * 
 * @Yuxin (your name) 
 * @version (a version number or a date)
 */
public class Flashing_Text extends Actor
{
    /**
     * Act - do whatever the Flashing_Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected GreenfootImage textImage;
    private int time=3;
    private boolean flash=true;
    
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
