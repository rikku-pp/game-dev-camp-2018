import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Page1 here.
 * 
 * @author Pink Programming 
 * @version 1.4
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
    
    @Override
    public void setMusic() {
        super.music = new BgMusic("Bonds.mp3");
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Text text = new Text("Three thousand years ago, Lysos founds a human colony on the isolated planet of Stratos in an effort to radically re-engineer human life into a happier, more pastoral form. She developed a strain of human beings that conceives clones in winter, while those conceived in summer obtain their genes through sexual reproduction just in case biological adaptation becomes necessary. Further, males and females have opposed seasons of sexual receptivity: men in summer and women in winter. This scheme is said to be stable over evolutionary time because women gain an advantage from self-cloning, while men only reproduce in summer. Finally, men have been made far less aggressive during the times that they are less sexually receptive and are much less numerous. The social result is that the vast majority of the population of Stratos consists of groups of female clones, each in its own social or economic niche. Over the centuries, these groups have come to dominate society. Men are confined to relatively few professions (such as sailing) and have a lower social status than clones, but higher than vars. In each generation, a few women vars become successful enough to found their own clan or 'hive' of clones.");
        addObject(text,500,300);
    }
}
