 import greenfoot.*; 
public class LoseGameState implements IBlackPantherState  
{
    public TChalla tchalla;

    public LoseGameState(TChalla tchalla)
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
    	Greenfoot.setWorld(new Restartmenu());
    	//tchalla.getWorld().addObject(new GameOverScreen("GameOver.png"), 500, 300);

    }
}
