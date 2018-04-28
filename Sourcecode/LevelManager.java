/**
 * Write a description of class LevelManager here.
 * 
* @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class LevelManager  implements IManager
{
    // instance variables - replace the example below with your own
    private int level;
    private World level0;
    private World level1;
    
    /**
     * Constructor for objects of class LevelManager
     */
    public LevelManager()
    {
        level0 =  new Level0();
        level1 = new Level1();
    }

    public void moveToNextLevel(){
        if(level == 0)
        
        ;
        if(level == 1)
        Greenfoot.setWorld(new Level1help());
        
        if(level == 2)
        ;
        
    }
}

