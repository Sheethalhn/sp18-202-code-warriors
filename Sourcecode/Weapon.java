import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Players implements ISubject
{
    IObserver observer; 
    ScoreBoard scoreBoard =  ScoreBoard.getInstance();
    Counter c = new Counter();
    public Weapon()
    {
          scoreBoard.attach(this);
          this.registerObserver(scoreBoard);  
    }
    public void act() 
    {
        setImage(new GreenfootImage("sword_flip.png"));
        move(5);
        removeObject();
    }
    
    public void removeObject()
    {
         if(isTouching(Rocket.class))
         {  
            destructImage();
            removeTouching(Rocket.class);
            notifyObservers(20);
            getWorld().removeObject(this);
            
 
         }
         else if(isTouching(Fire.class))
         {   

            destructImage();
            removeTouching(Fire.class);
            notifyObservers(20);
            getWorld().removeObject(this);
            
            
 
         }
         else  if(isTouching(Sword.class))
         {  
            destructImage();
            removeTouching(Sword.class);
            notifyObservers(20);
            getWorld().removeObject(this); 
              
 
         }
         else if(isAtEdge())
        {
            getWorld().removeObject(this);
        } 
    }
     
        public void destructImage()
        {
            Destruction image = new Destruction();
            getWorld().addObject(image,getX()+35 ,getY()); 
           
        }
        
     public void notifyObservers(int points)
     {
        ((ScoreBoard)observer).addScore(points);
     }
     
     
    public void registerObserver(IObserver o)
    { 
        observer = o;
    } 
     
}

  

     