import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Label represents a text label on the world.
 * 
 * @author Yixin Cai
 * @version November 2022
 */

public class Label extends Actor {
    // instance variables
    private String labelText;
    private int labelSize;
    private Color labelColor;
    
    /**
     * Constructors of Label
     */
    public Label() {
        this("");
    }
    
    /**
     * Constructors of Label
     * @param labelText the text shows on the screen
     */
    public Label(int labelText) {
        this(labelText + "");
    }
    
    /**
     * Constructors of Label
     * @param labelText the text shows on the screen
     */
    public Label(String labelText) {
        this(labelText, 25);
    }
    
    /**
     * Constructors of Label
     * @param labelText the text shows on the screen
     * @param labelSize the size of the text shows on the screen
     */
    public Label(String labelText, int labelSize) {
        this(labelText, labelSize, Color.GRAY);
    }
    
    /**
     * Constructors of Label
     * @param labelText the text shows on the screen
     * @param labelSize the size of the text shows on the screen
     */
    public Label(int labelText, int labelSize) {
        this(labelText + "", labelSize);
    }
    
    /**
     * King Constructors of Label
     * @param labelText the text shows on the screen
     * @param labelSize the size of the text shows on the screen
     * @param labelColor the color of the text shows on the screen
     */
    public Label(String labelText, int labelSize, Color labelColor) {
        this.labelText = labelText;
        this.labelSize = labelSize;
        this.labelColor = labelColor;
        setLabelImage();
    }
    
    /**
     * Constructors of Label
     * @param labelText the text shows on the screen
     * @param labelSize the size of the text shows on the screen
     * @param labelColor the color of the text shows on the screen
     */
    public Label(int labelText, int labelSize, Color labelColor) {
        this(labelText + "", labelSize, labelColor);
    }
    
    /**
     * Mehtod to set the text to image
     */
    private void setLabelImage() {
        setImage(new GreenfootImage(this.labelText, this.labelSize, this.labelColor, new Color(0, 0, 0, 0)));
    }
    
    /**
     * Method to update the Label
     * @param labelText the text shows on the screen
     */
    public void updateLabel(int labelText) {
        this.labelText = labelText + "";
        setLabelImage();
    }
    
    /**
     * Method to update the Label
     * @param labelText the text shows on the screen
     */
    public void updateLabel(String labelText) {
        this.labelText = labelText;
        setLabelImage();
    }
}
