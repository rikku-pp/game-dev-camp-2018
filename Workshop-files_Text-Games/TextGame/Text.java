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
    public int readerCharIndex = 0; //nummerordning för bokstäver, ska ökas varje gång en bokstav överförts från textContent till buffer
    public int readerLineIndex = 0; //nummerordning för rader, ska ökas varje gång buffern blivit för lång för att rymmas på skärmen
    public boolean newLineNeeded = false; //en signalflagga, som ska användas för det som behöver göras för att en ny rad ska bli till
    public GreenfootImage image; //bilden som ska innehålla hela texten
    public int fontHeight = 30; //pixels
    public int lineSpacing = 8; //pixels 
    public int containerWidth = 550; //pixels 
    public int containerHeight = 350; //pixels
    //dividera textrute-höjden, med textradhöjd+radavstånd
    public int lineTotal = Math.floorDiv(containerHeight, fontHeight+lineSpacing);
    //tom sträng, ska fyllas med bokstäver, vid varje skärmuppdatering
    public String[] buffer = new String[lineTotal]; 
    
    /************CONSTRUCTOR***********/
    public Text(String content){
        buffer[0] = "";
        //testa hur många rader det blir
        //System.out.println(lineTotal);
        
        /************TEXT SETUP***********/
        this.textContent = content; 
        // System.out.println(this.textContent);
        
        /************IMAGE SETUP*************/
        this.image = new GreenfootImage(containerWidth, containerHeight); 

        
    }
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.update();
        this.refresh();
    }
    /**
     * Update logics. Start with buffering text...
     * The code will run in sync with screen update, ca 25frames/second
     */
    private void update() {
        
        if(newLineNeeded){ //motsvarar if(newLineNeeded == true) {
            
            readerLineIndex++; // readerLineIndex = readerLineIndex + 1
            buffer[readerLineIndex] = ""; // gör den nya text-buffern redo att ta emot nya bokstäver
            newLineNeeded = false;
        }
        
        if(readerCharIndex < this.textContent.length()){    
            //lägg till nästa bokstav i ordningen till buffer
            this.buffer[readerLineIndex] += this.textContent.charAt(readerCharIndex); 
            
            //öka med 1, så att nästa uppdatering överför nästa bokstav på tur
            readerCharIndex++;
            
        }
    }
    /**
     * Refresh graphics. Start with the image of the text field...
     */
    private void refresh() {
        
        // Rensa image från tidigare bokstäver
        this.image.clear();
        
        /************LOCAL VARIABLE***********/
        GreenfootImage[] txtImgs = 
            new GreenfootImage[readerLineIndex+1];
        for(int i = 0; i < txtImgs.length; i++){
            txtImgs[i] = 
                new GreenfootImage( 
                    //använd bara de tecken som överförts
                    this.buffer[i], 
                    fontHeight, //text-storlek 
                    Color.WHITE, //textfärg
                    new Color(0,0,0,0), //bakgrundsfärg
                    Color.GRAY ); //text-kontur
            
            int verticalOffset = (lineSpacing + fontHeight) * i;
            // Merge the two images
            this.image.drawImage(txtImgs[i], 0, verticalOffset);
        }
        
        // Set merged image to scenario
        this.setImage(image);
        
        // kolla om textradsbilden är större än text-behållarbilden
        if( txtImgs[readerLineIndex].getWidth() > image.getWidth() ) {
            this.newLineNeeded = true;
            //System.out.println("new line needed");
        }
    }


}
