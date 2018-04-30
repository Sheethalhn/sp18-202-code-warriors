/**
 * Write a description of class StoryCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryCommand implements ButtonCommand
{
    Receiver playReceiver;
    
    public void setReceiver(Receiver newRec)
    {
        this.playReceiver = newRec;
    }
    
    public void executeCommand()
    {
        playReceiver.performAction();
    }
}
