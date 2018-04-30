import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Players
{
   public void act() 
    { 
        String worldname = getWorld().getClass().getName();
        turn(-1);
        setLocation(getX()-8, getY());                            
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }      
}
