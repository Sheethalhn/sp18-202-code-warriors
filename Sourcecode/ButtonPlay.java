import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonPlay here.
 * 
 * @author (your name)  
 */
public class ButtonPlay extends Button implements ButtonInvoker
{
    /**
     * Act - do whatever the ButtonPlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    ButtonCommand newButtonCommand;
    GifImage rocket = new GifImage("rocket.gif");
    
    public void act() 
    {
        super.act();
        String worldname = getWorld().getClass().getName();
        if(worldname == "Level1help"){
            setImage(new GreenfootImage("next.png"));
        }
    }    
    
    /**
     * click on this button to start the game
     */
    public void click()
    {
        newButtonCommand.executeCommand();
        if(Greenfoot.mouseClicked(this)){
            clickSound.play();            
        }
    }
    
    /**
     * Method to set command
     */
    public void setCommand(ButtonCommand newCmd)
    {
        this.newButtonCommand = newCmd;
    }
    
}