import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Destruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Destruction extends Actor
{
    Counter c = new Counter();
    
    public Destruction()
    {
        
         c.timer();
    }
       
       
    public void act() 
    {
       setImage(new GreenfootImage("explosion.png"));
       if(c.timeElapsed()>250)
       {
            getWorld().removeObject(this);
            c.timer();
        }
    }    
}
