import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class Button extends Actor
{
    GreenfootImage image;
    GreenfootSound clickSound;
    
    private static GreenfootSound[] sounds = {
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav")
    };
    private int soundNum;
    private int soundIndex;
    /**
     * Constractor
     */
    public Button(String file) {
        this.image = new GreenfootImage(file);
        setImage(this.image);
        
        this.soundNum = sounds.length;
        this.soundIndex = 0;
    }

    public Button(GreenfootImage image) {
        this.image = image;
        setImage(this.image);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            playSound();
        }
    }
    
    /**
     * Start playing sound if there is sound
     */
    public void playSound() {
        soundIndex++;
        if (soundIndex > (sounds.length - 1)) {
            soundIndex = 0;
        }
        sounds[soundIndex].play();
    }
    
    /**
     * Pause playing sound if there is sound
     */
    public void pauseSound() {
        sounds[soundIndex].pause();
    }
    
    /**
     * Method to determine weather sound is playing.
     * @return boolean True if the sound is playing, False otherwise.
     */
    public boolean isSoundPlaying () {
        return sounds[soundIndex].isPlaying();
    }
    
    /**
     * Method to get the sound in specific index.
     * @return GreenfootSound the greenfoot sound
     */
    public GreenfootSound getSound (){
        return sounds[soundIndex];
    }
}
