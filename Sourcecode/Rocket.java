  import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Enemy 
{
    /**
     * Act - do whatever the AttackObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public void act() 
    {
        //World worlda = getWorld();
        String worldname = getWorld().getClass().getName();
        if (worldname == "Level0")
        setImage(new GreenfootImage("greengem.jpg"));
        else if (worldname == "Level1")
        setImage(new GreenfootImage("Rocketlevel1.png"));
 
        super.act(); 

    }    
 

}
 
