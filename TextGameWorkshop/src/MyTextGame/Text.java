import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author Pink Programming
 * @version 1.1
 */
public class Text extends Actor
{
    private int counter = 0;
    String textContent;
    private String buffer = "";
    GreenfootImage image;
    
    public Text(String content) {
       textContent = content;
       //make it fill almost full screen (width:600, height: 400)
       image = new GreenfootImage(550,350);
    }
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Go through the string
        if(counter < textContent.length()) {
            buffer = buffer + textContent.charAt(counter);
            counter++;
        }
       
        //make the screen change in sync with 'act'
        refresh();
    }    
    /**
     * Redraw the image of the text field.
     */
    public void refresh()
    {
        //make a temporary background-image from the original main image
        GreenfootImage img = new GreenfootImage(image);
        //make a temporary image for the current text, with font size 20, text-color white, background-color black
        GreenfootImage txtImg = new GreenfootImage(this.buffer, 20, Color.WHITE, Color.BLACK);
        
        //set coordinates for upper left corner
        int x = 0;
        int y = 0;
        
        //put the text-image on top of the main image, using SCREEN-CORDINATES
        img.drawImage(txtImg, x, y);
        
        //put the newly blended image as diplay image
        setImage(img);
               
    }
}
