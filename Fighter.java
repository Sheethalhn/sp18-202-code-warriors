import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fighter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fighter extends Actor implements ISubject
{
    /**
     * Act - do whatever the Fighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IObserver observer;
    boolean isFighterMoved;
    
    public Fighter(){
        isFighterMoved = false;
    }
   
    public void act() 
    {
         checkCollision();
        if (Greenfoot.mousePressed(this) && !isFighterMoved)
        {
            isFighterMoved = true;
        }
        //dragging mouse
        if ((Greenfoot.mouseDragged(this)) && isFighterMoved)
        {
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
        
        }
        // check for collision after moving object
        if (Greenfoot.mouseDragEnded(this) && isFighterMoved)
        {
            isFighterMoved = false;
            checkCollision();
          
        }
    }    
    
    private void checkCollision()
    {
        if (isTouching(AttackObject.class)) 
        {
            removeTouching(AttackObject.class);
            MyWorld mWorld = (MyWorld)getWorld();
            notifyObservers(20);
        }
    }
    public void notifyObservers(int points){
        ((ScoreBoard)observer).addScore(points);
    }
    public void registerObserver(IObserver o){
        observer = o;
    }
}

