import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroWithSword here.
 * 
 * @author (Saranya) 
 * @version (a version number or a date)
 */
public class BlackPanther extends TChalla implements ISubject
{
    IObserver observer;
    boolean isFighterMoved;
    public int weaponCount;
    
    public BlackPanther() {
        isFighterMoved = false;
    }
    
    /**
     * Act - do whatever the HeroWithSword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    } 
    
    
    @Override
    public void collectWeapons() {
       // EnemyObject enemyObject = (EnemyObject)getOneIntersectingObject(EnemyObject.class);
            weaponCount++;
        //if(enemyObject != null){
        //   weaponCount++;
        //}
        displayWeaponCount();
    }
    
    @Override
    public void displayWeaponCount() {
        getWorld().showText("WeaponCount: " + weaponCount, 100, 35);
    }
    
    @Override
    public void notifyObservers(int points){
        ((ScoreBoard)observer).addScore(points);
    }
    
    @Override
    public void registerObserver(IObserver o){
        observer = o;
    }
}
