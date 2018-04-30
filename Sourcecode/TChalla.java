     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fighter here.
 * 
 * @author (Manisha) 
 * @version (a version number or a date)
 */
public class  TChalla extends Players implements ISubject
{
    IObserver observer; 
    boolean isFighterMoved;
    Counter counter = new Counter();
    Weapon sword;
    boolean isSwordscore;
    IBlackPantherState EndGameState, PlayGameState, BlackPantherState;
   
    public TChalla(){
        isFighterMoved = false;
        isSwordscore=false;
        PlayGameState = new PlayGameState(this); // * state pattern 1*
        EndGameState = new EndGameState(this); // * state pattern 1*
        BlackPantherState = PlayGameState;
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
        //stopGame();
        
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
            setLocation(getX(), getY() - 8);
            isFighterMoved = true;
            checkCollision();
            
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 8);
            isFighterMoved = true;
            
            checkCollision();
        }
        if (Greenfoot.isKeyDown("left")) {
            move(-8);
            isFighterMoved = true;
            checkCollision();
            
        }
        if (Greenfoot.isKeyDown("right")) {
            move(8);
            isFighterMoved = true;
            checkCollision();
        }
    }
        public boolean stopGameForScore(int score) {
        
        if(score >= 200) {
        	setState(PlayGameState);
        	display();
        	Greenfoot.stop();
        	return true;
        }
        return false;
 
    }
    
    
    public boolean stopGame() {
        if(((HealthScore)observer).getHealth() < 1) {
        	setState(EndGameState);
        	display();
        	Greenfoot.stop();
        	return true;
        }
        return false;
   
    }
    public void attackWeapon()
    {
        if(counter.timeElapsed()> 400 )
        {
            if((Greenfoot.isKeyDown("space")) && (((HealthScore)observer).getSword() > 0))
            {
            World  world =  this.getWorld();
            Weapon sword = new Weapon();
            world.addObject(sword, this.getX()+this.getImage().getWidth()/2+20   , this.getY()); 
            //Greenfoot.playSound("SwordThrow.wav ");
            counter.timer();
            isSwordscore = true;
            notifyObservers(-10);
             
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
            isSwordscore = false;
            notifyObservers(-20);
        }
        else if(isTouching(Fire.class))
        {
            removeTouching(Fire.class);
            Level1 level1 = (Level1)getWorld(); 
            isSwordscore = false;
            notifyObservers(-20);
        }
        else if(isTouching(Sword.class))
        { 
            removeTouching(Sword.class);
            Level1 level1 = (Level1)getWorld();
            isSwordscore = false;
            notifyObservers(-20);
        }
    }
    
    public void notifyObservers(int points){
        //rakhee
        if (isSwordscore)
        ((HealthScore)observer).addSwordScore(points);
        else
             ((HealthScore)observer).addHealthScore(points);
    }
    public void registerObserver(IObserver o){ 
        observer = o;
    } 
   
   // public void collectWeapons() {
   // }
   
   // public void displayWeaponCount() {
   // }
      public void display() {
        BlackPantherState.display();
    }
    void setState(IBlackPantherState state) {
    	
        this.BlackPantherState = state;
        
        //System.out.println("State set to: "+ this.BlackPantherState);
    }
    IBlackPantherState getPlayGameState()
    {
        return PlayGameState; //BlackPantherState 
    }    
    IBlackPantherState getEndGameState()
    {
        return EndGameState;  //BlackPantherState
    }
}

