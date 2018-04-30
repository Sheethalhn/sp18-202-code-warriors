 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Sword  extends Players implements Enemy
{

    public void act() 
    {
        String worldname = getWorld().getClass().getName();
        setImage(new GreenfootImage("sword_flip.png"));
        if (worldname == "Level1")
        {
            setImage(new GreenfootImage("spikeball.png"));
            turn(-1);
        }
        setLocation(getX()-8, getY());                            
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
        
  
    }
    
       
 
} 
