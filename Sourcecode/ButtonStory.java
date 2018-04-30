import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonStory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonStory extends Button implements ButtonInvoker
{
    private Story story;
    private ButtonCommand newButtonCommand;
   
    public ButtonStory()
    {
        story = new Story();
    }
    public Story getStory()
    {
        return story;
    }
    
    /**
     * Act - do whatever the ButtonHelp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }   
    
    /**
     * By clicking on the help  appears.
     */
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            clickSound.play();            
        }
       newButtonCommand.executeCommand();
    }
    
    public void setCommand(ButtonCommand newCmd)
    {
        this.newButtonCommand = newCmd;
    }
}
