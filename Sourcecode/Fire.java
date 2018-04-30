     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Players implements Enemy
{ 
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button   gets pressed in the environment.
     */
    GifImage enemy1 = new GifImage("enemy2.gif");
    
    public void act() 
    { 
        String worldname = getWorld().getClass().getName();
        if (worldname == "Level0") {
          setImage(new GreenfootImage("fireball.png"));
          turn(-1);
         
        }
        else if (worldname == "Level1") {
        setImage(enemy1.getCurrentImage());}  
        
        setLocation(getX()-8, getY()); 
                              
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }     
         
    
} 
  
