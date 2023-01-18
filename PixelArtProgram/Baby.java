import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pengy here.
 * 
 * @author Gloria Chan
 * @version (a version number or a date)
 */
public class Baby extends Penguin
{
    private boolean active;
    
    public Baby()
    {
        active = false;
        
        GreenfootImage penguinBaby = new GreenfootImage("defaultPenguin.png");
        setImage(penguinBaby);
    }
    
    public void act()
    {
        // Every 10 seconds, if the baby is not doing any action, they will chirp or sing.
    }
    
    private void poked()
    {
        int actionType = Greenfoot.getRandomNumber(1);
        
        // Localized to clicking his belly
        if (Greenfoot.mouseClicked(this))
        {
            if (actionType == 0)
            {
                //Insert blushing gif, frame by frame plays, with timer.
                // active boolean is true when the frames are being went through.
                
            }
            else if (actionType == 1)
            {
                //Insert laughing gif.
            }
        }
    }
}
