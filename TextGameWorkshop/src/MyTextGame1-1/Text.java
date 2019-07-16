import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author Pink Programming
 * @version 1.1
 */
public class Text extends Actor
{
    private int readerIndex = 0;
    private String buffer = "";
    String textContent;
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
        //make changes that effects the state of this Actor
        update();
        //make above changes appear on screen in sync with each 'Act'
        refresh();
    }
    
    /**
     * Update logics. Start with buffering text...
     */
    private void update() {
        
        if(readerIndex < textContent.length()) {
            buffer = buffer + textContent.charAt(readerIndex);
            readerIndex++;
        }
    }
    /**
     * Update graphics. Start with the image of the text field...
     */
    private void refresh() {
       //make a temporary image for the text, with font size 20, text-color white, background-color black
       GreenfootImage txtImg = new GreenfootImage(this.buffer, 20, Color.WHITE, Color.BLACK);
       //put the text-image on top of the main image, using SCREEN-CORDINATES
       image.drawImage(txtImg, 0, 0);
       //use the new image instance to display Actor in the World, until setImage is called again.
       setImage(image);
    }
}
