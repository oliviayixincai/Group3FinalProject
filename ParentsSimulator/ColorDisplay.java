import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This Actor is used in PixelArtWorld to display each colour that is needed to complete
 * the pixel art.
 * 
 * @author Gloria Chan
 * @version January 19, 2023
 */
public class ColorDisplay extends PixelArtTools
{
    /**
     * Accepts specific size parameters. The colour parameter is the colour of the block
     * and the number parameter displays the number that the colour is associated with.
     */
    public ColorDisplay(int size, Color colour, int num)
    {
        GreenfootImage colorBar = new GreenfootImage(size, size);
        colorBar.setColor(colour);
        colorBar.fillRect(0, 0, size, size);
        if (colour.equals(Color.BLACK)) // If the colour is black, white text is needed to make the number visible.
        {
            colorBar.setColor(Color.WHITE);
        }
        else
        {
            colorBar.setColor(Color.BLACK);
        }
        String text = String.valueOf(num);
        colorBar.drawString(text, size/2, size/2);
        setImage(colorBar);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
