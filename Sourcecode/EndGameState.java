/**
 * Write a description of class MeridaLostState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameState implements IBlackPantherState  
{
    public TChalla tchalla;

    public EndGameState(TChalla tchalla)
    {
        this.tchalla = tchalla;
    }

    public  boolean isAlive()
    {
        return true;
    }
    
    public boolean isDead()
    {
        return false;
    }
    
     
    public void setState()
    {
        //brave.setState(brave.getBraveDeadState());
    }
    
    public void display()
    {
    	//System.out.println("Health Finish State - Lose and End Game");
    	tchalla.getWorld().addObject(new GameOverScreen("GameOverLose.jpeg"), 500, 300);
    }
}
