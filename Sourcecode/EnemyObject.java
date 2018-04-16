import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyObject extends Players 
{
    /**
     * Act - do whatever the AttackObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setLocation(getX()-8, getY()); //I can tell that setLocation is a method but I have no idea what getX means
        turn(-1);
        
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }    

}

