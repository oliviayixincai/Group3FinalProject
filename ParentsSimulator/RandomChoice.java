import greenfoot.*;

/**
 * Write a description of class RandomChoice here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class RandomChoice extends Actor {
    // declare variables and objects
    private String answer;
    private int[] results;
    private GreenfootSound clickSound;

    /**
     * Constructor for objects of class RandomChoice
     * @param answer a string store the answer
     * @param results an int[] to store the results of the answer
     */
    public RandomChoice(String answer, int[] results) {
        this.answer = answer;
        this.results = results;
        
        GreenfootImage image = new GreenfootImage("randomChoicesAnswer.png");
        image.setColor(Color.GRAY);
        image.drawImage(new GreenfootImage(this.answer, 20, Color.GRAY, new Color(0, 0, 0, 0)), 30, image.getHeight() / 2 - 5);
        setImage(image);
        
        clickSound = new GreenfootSound("click.wav");
    }
    
    /**
     * Act - do whatever the RandomChoice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            clickSound.play();
            ActivityEffectWorld w = (ActivityEffectWorld) getWorld();
            w.finishRandomChoice(this.results);
        }
    }
}
