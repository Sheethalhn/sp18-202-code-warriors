     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy extends Players
{
     
    
    public Enemy()
    {
       
    }
    public void act() 
    {
        setLocation(getX()-8, getY());                            
        // turn(-1);
        
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }
    
    
}
  