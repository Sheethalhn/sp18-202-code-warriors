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
    private int health;
    
    public HealthScore() {
        health = 0;
        //GreenfootImage scoreBoardImage = getImage();
        //scoreBoardImage.scale(scoreBoardImage.getWidth(), scoreBoardImage.getHeight());
        //setImage(scoreBoardImage);
    }
    public void act() 
    {
        showHealth();
    }    
    private void showHealth()
    {
        getWorld().showText("Health: " + health, 100, 35);
    }
    public void addHealthScore(int healthpoints){
        health+=healthpoints;
    }
    public void attach(ISubject sub){
        subject = sub;
    }
    
    public void detach(ISubject s){
        subject = null;
    }
}
