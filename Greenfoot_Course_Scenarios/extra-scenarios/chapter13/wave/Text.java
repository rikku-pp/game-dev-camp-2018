import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class provides objects that just show a bit of text on the screen.
 */
public class Text extends Actor
{
    public Text(int length)
    {
        setImage(new GreenfootImage(length * 12, 16));
    }

    public Text(String text)
    {
        this (text.length());
        setText(text);
    }

    public void setText(String text)
    {
        GreenfootImage image = getImage();
        image.clear();

        // calculate width of text in pixels
        int textWidth = new GreenfootImage(text, image.getFont().getSize(), Color.WHITE, Color.BLACK).getWidth();
        
        image.drawString(text, (image.getWidth() - textWidth) / 2, 12);
    }
}
