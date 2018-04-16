import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Switch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Switch extends Actor
{
    /**
     * Act - do whatever the Switch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean clicked = false;
    String buttonText = "";

    public Switch() {
        this("");
        //GreenfootImage scoreBoardImage = getImage();
        //scoreBoardImage.scale(scoreBoardImage.getWidth(), scoreBoardImage.getHeight());
        //setImage(scoreBoardImage);
    }
    
    public Switch(String text)
    {
        setText(text);
    }
    
    public void setText(String text){
        buttonText=text;
        GreenfootImage textImg=new GreenfootImage(" "+text+" ", 24, Color.BLACK, new Color(0, 0, 0, 0));
        GreenfootImage image=new GreenfootImage(textImg.getWidth()+8, textImg.getHeight()+8);
        image.setColor(Color.GRAY);
        image.fill();
        image.setColor(Color.GRAY);
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);
        image.setColor(Color.BLACK);
        image.drawImage(textImg, (image.getWidth()-textImg.getWidth())/2, (image.getHeight()-textImg.getHeight())/2);
        setImage(image);
    }

    
    public void act() 
    {   
        if(Greenfoot.mouseClicked(this)) 
            clicked = true;

    } 
    
    public boolean gotClicked() { 
        boolean wasClicked = clicked;
        clicked = false;
        return wasClicked;
    }
    
    public String getText(){
        return buttonText;
    }
}
