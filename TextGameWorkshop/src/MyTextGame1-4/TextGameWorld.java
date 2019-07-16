import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class TextGameWorld here.
 * 
 * @author Pink Programming 
 * @version 1.4
 */
public class TextGameWorld extends World
{
    TextGameWorld nextPage;
    BgMusic music;
    
    boolean wasSpaceDown = false;
    /**
     * Constructor for objects of class TextGameWorld.
     * 
     */
    public TextGameWorld()
    {   
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        prepare();
        setNext();
        setMusic();
    }

    public void act() {
        //logic for enabling keyboard "click" for SPACE-key
        if(Greenfoot.isKeyDown("space")) {
            wasSpaceDown = true;
        } else if (wasSpaceDown) {
            wasSpaceDown = false;
            changePage();
        } 
        
        //logic for music
        if(music != null) {
            music.update();
        }
    }
    
   /**
    * Override when subclass should link to another
    */
    public void setNext(){
    
    }
    
    /**
    * Override when subclass should link to another
    */
    public void setMusic(){
        
    }
    
   /**
    * Instantly switches the game to the world set as next
    */
    public void changePage() {
        if(nextPage != null) {
            Greenfoot.setWorld(nextPage);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
