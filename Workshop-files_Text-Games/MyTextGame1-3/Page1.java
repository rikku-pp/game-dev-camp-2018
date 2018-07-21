import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Page1 here.
 * 
 * @author Pink Programming 
 * @version 1.3
 */
public class Page1 extends TextGameWorld
{

    /**
     * Constructor for objects of class Page1.
     * 
     */
    public Page1()
    {
        super();
        prepare();
    }

    @Override
    public void setNext(){
        super.nextPage = new Page2();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
}
