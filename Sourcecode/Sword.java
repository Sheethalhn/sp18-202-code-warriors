import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Sword extends Enemy
{

    public void act() 
    {
        String worldname = getWorld().getClass().getName();
        if (worldname == "Level1")
        {
            setImage(new GreenfootImage("spikeball.png"));
            turn(-1);
        }
        
        super.act();
  
    }
    
       
 
} 
