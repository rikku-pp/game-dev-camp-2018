import greenfoot.*;

/**
 * BgMusic handles Background Music, as optional part of a "Page"
 * 
 * @author PinkProgramming
 * @version 1.4
 */
public class BgMusic  
{
    // instance variables - replace the example below with your own
    GreenfootSound musicIntro;
    GreenfootSound musicRepeat;
    boolean didIntroPlay = false;
    /**
     * Constructor for BgMusic with one sound file on repeat
     */
    public BgMusic(String filePath)
    {
        musicRepeat = new GreenfootSound(filePath);
    }
     /**
     * Constructor for BgMusic with one sound as intro, and next file on repeat
     */
    public BgMusic(String filePathIntro, String filePath)
    {
        musicIntro = new GreenfootSound(filePathIntro);
        musicRepeat = new GreenfootSound(filePath);
    }
    public void startIntro(){
        if(musicIntro != null){
            musicIntro.play();
            didIntroPlay = true;
        }
    }
    public void startRepeat(){
        if(musicRepeat != null) {
            musicRepeat.playLoop();
        }
    }
    
    /**
     * Update logic for playback
     */
    public void update()
    {
        if(musicRepeat != null) { 
            
            if(musicIntro == null && !musicRepeat.isPlaying()){
                startRepeat();
            }
            
            if(musicIntro != null && !musicRepeat.isPlaying() && !musicIntro.isPlaying()) {
                startIntro();
            }
            
            if(didIntroPlay && !musicIntro.isPlaying()){
                startRepeat();
            }
        
        }
    }
}
