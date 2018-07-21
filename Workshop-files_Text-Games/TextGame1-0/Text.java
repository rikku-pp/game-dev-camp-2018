import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author Rikku
 * @version 1.0
 */
public class Text extends Actor
{
    /************INSTANCE VARIABLES*************/
    public String textContent; //hela min text utan radbrytningar
    public GreenfootImage image; //bilden som ska innehålla hela texten

    /************CONSTRUCTOR***********/
    public Text(String content){
        
        /************TEXT SETUP***********/
        this.textContent = content; 
        // System.out.println(this.textContent);
        
        /************IMAGE SETUP*************/
        this.image = new GreenfootImage(550, 350); //width, height. in pixels

        /************LOCAL VARIABLE***********/
        GreenfootImage txtImg = 
            new GreenfootImage( 
                this.textContent, 
                20, //font height 
                Color.WHITE, 
                new Color(0,0,0,0), 
                Color.GRAY );
                
        // Merge the two images
        this.image.drawImage(txtImg, 0, 0);
        
        // Set merged image to scenario
        this.setImage(image);
    }
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
