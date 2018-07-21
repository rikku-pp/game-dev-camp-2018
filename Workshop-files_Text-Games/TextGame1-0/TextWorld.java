import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display text
 * 
 * @author Rikku 
 * @version 1.0
 */
public class TextWorld extends World
{

    /**
     * Constructor for objects of class TextWorld.
     * 
     */
    public TextWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Text text = new Text("Min text min text");
        addObject(text,324,232);
    }
}
