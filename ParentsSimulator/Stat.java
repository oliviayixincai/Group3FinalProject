import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stat here.
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 */
public class Stat extends LabelAbstract
{
    /**
     * Act - do whatever the Stat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String name;
    
    public Stat(int value){
        this.value = value;
    }
    
    public Stat(String name, int value){
        this.value = value;
        this.name = name;
    }
    
    public void updateImage(){
        GreenfootImage display = new GreenfootImage("" + getValue(), 40, Color.GRAY, transparent);
        setImage(display);
    }
    
    public void setStat(int newValue)
    {
        value = newValue;
        updateImage();
    }
    
    public void addPoint(int point)
    {
        point = Math.max(point, -this.value);
        this.value += point;
        updateImage();
        
        GreenfootImage addText = new GreenfootImage((point >= 0 ? "+ " : "") + point, 20, Color.BLACK, transparent);
        getWorld().addObject(new FadeEffect(addText), getX() + 60, getY() - 10);
    }
}
