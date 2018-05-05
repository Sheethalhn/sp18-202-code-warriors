     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
     import java.util.concurrent.TimeUnit;

/**
 * Write a description of class Fighter here.
 * 
 * @author (Manisha) 
 * @version (a version number or a date)
 */
public class TChalla extends Players implements ISubject, BoostDecorator
{
    IObserver observer; 
    boolean isFighterMoved;
    Counter counter = new Counter();
    Weapon sword;
    boolean isSwordscore;
    IBlackPantherState LoseGameState, PlayGameState, WinGameState, BlackPantherState;
    int count = 0;
    public GreenfootImage image1 = new GreenfootImage("panthergrow1.png");
    public GreenfootImage image2 = new GreenfootImage("panthergrow2.png");
    public GreenfootImage image3 = new GreenfootImage("panthergrow3.png");
    public GreenfootImage image4 = new GreenfootImage("panthergrow4.png");
    public GreenfootImage image5 = new GreenfootImage("panthergrow5.png");
   
    public TChalla(){
        isFighterMoved = false;
        isSwordscore=false;
        PlayGameState = new PlayGameState(this); // * state pattern 
        LoseGameState = new LoseGameState(this); // * state pattern 
        WinGameState = new WinGameState(this); // * state pattern 
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
           
            if(this.getY()-this.getImage().getHeight()/2 > 0)
                this.setLocation(this.getX(), this.getY() - 5);
            isFighterMoved = true;
            checkCollision();
            
        }
        if (Greenfoot.isKeyDown("down")) {
            if(this.getY()+this.getImage().getHeight()/2 < getWorld().getHeight())
                this.setLocation(this.getX(), this.getY() + 5);
            isFighterMoved = true;
            
            checkCollision();
        } 
        if (Greenfoot.isKeyDown("left")) {
            if(this.getX()-this.getImage().getWidth()/2 > 0)
                this.setLocation(this.getX() - 5, this.getY());
            isFighterMoved = true;
            checkCollision();
            
        }
        if (Greenfoot.isKeyDown("right")) {
            if(this.getX()+this.getImage().getWidth()/2 < getWorld().getWidth())
                this.setLocation(this.getX() + 5,this.getY());
            isFighterMoved = true;
            checkCollision();
        }
        
    }
    
    public boolean stopGameForScore(int score) {
        
        if(score >= 320) {
            setState(WinGameState);
            display();
            Greenfoot.stop();
            return true;
        }
        return false;
 
    }
    
    
    public boolean stopGame() {
        if(((HealthScore)observer).getHealth() < 1) {
            setState(LoseGameState);
            display();
            return true;
        }
        return false;
   
    }
    
    public void restartGame()
    {
        setState(PlayGameState);
    }
    public void attackWeapon()
    {
        if(counter.timeElapsed()> 400 )
        {
            if((Greenfoot.isKeyDown("space")) && (((HealthScore)observer).getSword() > 0))
            {
            World  world =  this.getWorld();
            Weapon sword = new Weapon();
            world.addObject(sword, this.getX()+this.getImage().getWidth()/2+20, this.getY()); 
            //Greenfoot.playSound("SwordThrow.wav ");
            counter.timer();
            isSwordscore = true;
            notifyObservers(-1);
             
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
        
        else if(isTouching(Star.class))
        { 
            removeTouching(Star.class);
            Level1 level1 = (Level1)getWorld();
            isSwordscore = false;
            count++;
            boost();
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
    IBlackPantherState getLoseGameState()
    {
        return LoseGameState;  //BlackPantherState
    }
    IBlackPantherState getWinGameState()
    {
        return WinGameState;  //BlackPantherState
    }
    public void boost(){
       if (count == 1){
        setImage(image1);
       }
       if (count == 2){
        setImage(image2);
       }
       if (count == 3){
        setImage(image3);
       }
       if (count == 4){
        setImage(image4);
       }
       if (count == 5){
        setImage(image5);
       }
       
    }
    
}

