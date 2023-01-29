import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This Actor is used in PixelArtWorld to display each colour that is needed to complete
 * the pixel art.
 *
 * @author Gloria Chan
 * @version January 19, 2023
 */
public class ColorBlock extends PixelArtTools
{
    private boolean correct;
    private boolean colourable = true;
    private boolean selected;
    private Color correctColour;
    private Color currColour;
    private Color selColour;
    
    private Color colour;
    private int num;
    private int size;
    
    /**
     * Constructor for each colour block in the PixelArtWorld grid.
     * @param size specifications for each grid cell.
     * @param num is the number associated with the pixel colour.
     * @param colour is the colour that the pixel cell must be (based on the pixel art).
     * @param currColour is the colour that the pixel cell is currently.
     */
    public ColorBlock(int size, int num, Color colour, Color currColour)
    {
        this.num = num;
        this.size = size;
        this.correctColour = colour;
        this.currColour = currColour;
        selected = false;
        
        // Before the use can play, the number (corresponding to the pixel's colour
        // will be displayed)
        GreenfootImage pixel = new GreenfootImage(size, size);
        pixel.setColor(currColour);
        pixel.fillRect(0, 0, size, size);
        pixel.setColor(Color.BLACK);
        String text = String.valueOf(num);
        pixel.drawString(text, size/2, size/2);
        setImage(pixel);
    }
    
    public void act()
    {
        changeColours();
    }
    
    /**
     * Method that checks to see whether the pixel cell is the correct colour and changes
     * the colour of the box everytime the user paints on it.
     */
    public void changeColours(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        // In order to colour, the space bar must be down.
        if (Greenfoot.isKeyDown("space") && Greenfoot.mouseMoved(this) && colourable)
        {
            // Checks which colour the user selected to colour with.
            PixelArtWorld w = (PixelArtWorld) getWorld();
            Color selColour = w.returnColour();
            
            // If the wrong colour is used to paint the pixel block,
            // the number (which corresponds with the colour) will remain.
            GreenfootImage pixel = getImage();
            pixel.setColor(selColour);
            pixel.fillRect(0, 0, size, size);
            pixel.setColor(Color.BLACK);
            pixel.drawString(String.valueOf(num), size/2, size/2);
            setImage(pixel);
            
            // If the correct colour is used to paint the pixel block,
            // the colour will be locked into place (unable to change the colour).
            if (selColour.equals(correctColour))
            {
                pixel = getImage();
                pixel.setColor(selColour);
                pixel.fillRect(0, 0, size, size);
                setImage(pixel);
                colourable = false;
            }
        }
    }
    
    /**
     * Method that returns whether the block is still colourable.
     */
    public boolean checkColour(){
        return colourable;
    }
}
