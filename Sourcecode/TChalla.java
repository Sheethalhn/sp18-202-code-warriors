   import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fighter here.
 * 
 * @author (Manisha) 
 * @version (a version number or a date)
 */
public class  TChalla extends Players implements ISubject, AttackDecorator
{
    IObserver observer; 
    boolean isFighterMoved;
    Counter counter = new Counter();
    Weapon sword;
     
   
    public TChalla(){
        isFighterMoved = false;
    }
   
    /**
     * Act - do whatever the Fighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         checkCollision();
        KeyMovements(); 
        attackWeapon();

        
    }    
    
    public void KeyMovements()
    {
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
    
    public void attackWeapon()
    {
        if(counter.timeElapsed()> 400 )
        {
            if(Greenfoot.isKeyDown("space"))
            {
            World  world =  this.getWorld();
            Weapon sword = new Weapon();
            world.addObject(sword, this.getX()+this.getImage().getWidth()/2+20   , this.getY()); 
            counter.timer();
            
            }
            
        }    
    } 
    
    private void checkCollision()
    {  
        //Rocket rocket = (Rocket)getOneIntersectingObject(Rocket.class);
        if(isTouching(Rocket.class))
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
        else if(isTouching(Sword.class))
        { 
            removeTouching(Sword.class);
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

