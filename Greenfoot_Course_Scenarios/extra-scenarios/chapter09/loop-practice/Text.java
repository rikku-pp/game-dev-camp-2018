import greenfoot.*;


/**
 * An object showing some text.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Text extends Actor
{
    public Text(String text)
    {
        GreenfootImage img = new GreenfootImage(text, 64, Color.WHITE, new Color(0,0,0,0));
        setImage(img);
    }
}
