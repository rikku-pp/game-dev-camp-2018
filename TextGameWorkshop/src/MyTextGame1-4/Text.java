import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;

/**
 * Write a description of class TextBox here.
 * 
 * @author Pink Programming 
 * @version 1.4
 */
public class Text extends Actor
{
    String textContent;
    GreenfootImage image;
    Color fontColor = Color.WHITE;
    Color textBorderColor = new Color(0,0,0,190);
    Color bgColor = new Color(0, 0, 0, 90);
    int fontHeight = 30; //pixels
    int lineSpacing = 5; //pixels 
    int containerWidth = 950; //pixels 
    int containerHeight = 550; //pixels
    int lineTotal = Math.floorDiv(containerHeight, fontHeight+lineSpacing);
    private String[] buffer = new String[lineTotal];
    private GreenfootImage[] txtImgs = new GreenfootImage[lineTotal];
    
    private int readerCharIndex = 0;
    private int readerLineIndex = 0;
    private boolean newLineNeeded = false; 
    
    public Text(String content) {
       textContent = content + " "; //must end with whitespace
       
       //make it fill almost full screen (width:600, height: 400)
       image = new GreenfootImage(containerWidth, containerHeight);
       Arrays.fill(buffer, "");
    }
    public Text(String content, Color color) {
       textContent = content + " "; //must end with whitespace
       fontColor = color;
       
       //make it fill almost full screen (width:600, height: 400)
       image = new GreenfootImage(containerWidth, containerHeight); 
       Arrays.fill(buffer, "");
    }
    public void act() {
       update();
       refresh();
    }
    /**
     * Update logics. Start with buffering text...
     */
    private void update() {
        int charsLeft = textContent.length() - 1 - readerCharIndex;
        
        //Buffer another character
        if( charsLeft > 0) {
            buffer[readerLineIndex] += textContent.charAt(readerCharIndex);
            
            //Check if line break is needed
            if( charsLeft > 1 && textContent.charAt(readerCharIndex) == ' ') { //look ahead for whitespace
                
                int lookAhead =  readerCharIndex + 1;
                char nextChar = textContent.charAt(lookAhead);
                
                //increase lookAhead until a whitespace is found
                while( nextChar  != ' ') {     
                    nextChar =  textContent.charAt(lookAhead++); //will increase lookAhead before looking at it
                }
                
                String nextWord = textContent.substring(readerCharIndex+1, lookAhead);
                GreenfootImage txtImgTest = new GreenfootImage(buffer[readerLineIndex]+nextWord, fontHeight, fontColor, new Color(0,0,0,255));
                //newLineNeeded =  (txtImgTest.getWidth() > containerWidth ? true : false );
                if( txtImgTest.getWidth() > containerWidth ) {
                    newLineNeeded = true;
                }

            }
            
            readerCharIndex++;
        }
        
        //Buffer another line
        if(newLineNeeded) {
            newLineNeeded = false;
            readerLineIndex++;
            buffer[readerLineIndex] = "";
            
        }
        
    }
    /**
     * Update graphics. Start with the image of the text field...
     */
    private void refresh() {

       image.clear(); //needed to remove text-images in last frame
       
       for (int i = 0; i < txtImgs.length; i++) {
           
           int verticalOffset = i * (lineSpacing + fontHeight);
           if(i == readerLineIndex || txtImgs[i]==null){
               //make a new image for the text, with font size 20, text-color white, background-color black
               txtImgs[i] = new GreenfootImage(buffer[i], fontHeight, fontColor, new Color(0,0,0,0), textBorderColor);
           } 
           
           //put the text-image on top of the main image, using vertical offset
           image.drawImage(txtImgs[i], 0, verticalOffset);
           
       }
       
       //use the new image instance to display Actor in the World, until setImage is called again.
       setImage(image);
    }


}
