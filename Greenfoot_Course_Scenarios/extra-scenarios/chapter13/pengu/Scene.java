import greenfoot.*; 

/**
 * This is the whole scene. It creates and contains the objects that are in it.
 */
public class Scene extends World
{
    boolean faceLeft = true;
    boolean faceRight = false;
    
    public Scene()
    {    
        super(750, 500, 1);    // define size and resolution
a
        
        
        addObject ( new Cliff(faceRight), 85, 441);
        addObject ( new Cliff(faceLeft), 665, 441); //true== flip == face left
        new Cliff 
        
        addObject ( new Cloud(), 369, 315 );
        
        addObject ( new Pengu(), 66, 244 );
    }
}
