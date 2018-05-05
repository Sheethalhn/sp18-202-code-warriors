import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthScore extends Actor implements IObserver
{
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ISubject subject;
    private static int health, sword;
    
    public HealthScore() {
        health = 0;
        sword = 0;
    }
    public void act() 
    {
        showHealth();
        GreenfootImage healthImage = getImage();
        healthImage.clear();
    }    
    private void showHealth()
    {
        getWorld().showText("Health: " + health, 100, 35);
        getWorld().showText("Sword: " + sword, 100, 55);
    }
    public void addHealthScore(int healthpoints){
        health+=healthpoints;
    }
    public void addSwordScore(int swordpoints){
        sword+=swordpoints;
    }
    public void attach(ISubject sub){
        subject = sub;
    }
    
    public void detach(ISubject s){
        subject = null;
    }
    public int getHealth(){
        return health;
    }
    public int getSword(){
        return sword;
    }
    public void setHealth(int h){
        health = h;
    }
    public void setSword(int sw){
         sword =sw;
    }
    
}
