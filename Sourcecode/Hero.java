 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fighter here.
 * 
 * @author (Manisha) 
 * @version (a version number or a date)
 */
public class Hero extends Players implements ISubject, AttackDecorator
{
    IObserver observer;
    boolean isFighterMoved;
   
    public Hero(){
        isFighterMoved = false;
    }
   
    /**
     * Act - do whatever the Fighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
       
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 3);
            isFighterMoved = true;
            checkCollision();
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 3);
            isFighterMoved = true;
            checkCollision();
        }
        if (Greenfoot.isKeyDown("left")) {
            move(-3);
            isFighterMoved = true;
            checkCollision(); 
        }
        if (Greenfoot.isKeyDown("right")) {
            move(3);
            isFighterMoved = true;
            checkCollision();
        }
    }    
    
    private void checkCollision()
    {
        //Rocket rocket = (Rocket)getOneIntersectingObject(Rocket.class);
        if(isTouching(Rocket.class)  )
        {
            removeTouching(Rocket.class);
            Level1 level1 = (Level1)getWorld();
            notifyObservers(20);
            collectWeapons(); 
        }
        else if(isTouching(Fire.class))
        {
            removeTouching(Fire.class);
            Level1 level1 = (Level1)getWorld(); 
            notifyObservers(20);
            collectWeapons(); 
        }
        else if(isTouching(Bat.class))
        {
            removeTouching(Bat.class);
            Level1 level1 = (Level1)getWorld();
            notifyObservers(20);
            collectWeapons();
        }
    }
    
    public void notifyObservers(int points){
        ((ScoreBoard)observer).addScore(points);
    }
    public void registerObserver(IObserver o){ 
        observer = o;
    } 
   
    public void collectWeapons() {
    }
   
    public void displayWeaponCount() {
    }
}

