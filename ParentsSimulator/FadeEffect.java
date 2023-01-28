import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FadeEffect here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class FadeEffect extends Actor
{
    // declare and inilialize all the variables
    protected int duration = 90;
    
    private int tik = 0;
    
    /**
     * The constructor of FadeEffect.
     * @param image a GreenfootImage
     */
    public FadeEffect(GreenfootImage image) {
        image.setTransparency(0);
        setImage(image);
    }

    /**
     * Act - do whatever the FadeEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tik++;
        
        int fadeDuration = this.duration / 3;
        
        if (tik >= this.duration) {
            getWorld().removeObject(this);
        }
        else if (tik > this.duration - fadeDuration) {
            fade(this.duration - tik, fadeDuration);
        }
        else if (tik < fadeDuration) {
            fade(tik, fadeDuration);
        }
    }
    
    /**
     * This is a method used to fade the image.
     * @param numerator this is an int to calculate the time of the fade effect
     * @param dinominator this is an int to calculate the time of the fade effect
     */
    private void fade(int numerator, int dinominator) {
        double percent = numerator / (double)dinominator;
        int newTransparency = (int)(percent * 255);
        getImage().setTransparency(newTransparency);
    }
}
