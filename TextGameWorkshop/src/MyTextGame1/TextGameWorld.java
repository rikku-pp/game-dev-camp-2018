import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextGameWorld extends World
{
    /**
     * Constructor for objects of class TextGameWorld.
     * 
     */
    public TextGameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Page2());
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Text text = new Text("It has been said...");
        addObject(text,402,268);
        text.setLocation(302,197);
    }
}
