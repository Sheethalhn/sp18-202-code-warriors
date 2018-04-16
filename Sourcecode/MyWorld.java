import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Hero hero;
    private HeroWithSword heroWithSword;
    private ScoreBoard scoreBoard;
    private EnemyObject enemyObject;
    private Switch textButton = null;
    
    public MyWorld()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        hero = new Hero();
        scoreBoard =  new ScoreBoard();
        enemyObject = new EnemyObject();
        textButton = new Switch("Click here to change to swordmode");
        addObject(hero, 40, 200);
        addObject(scoreBoard, 900, 35);
        addObject(textButton, 600, 35);
        scoreBoard.attach(hero);
        hero.registerObserver(scoreBoard);
    }
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(enemyObject, 1200, Greenfoot.getRandomNumber(360));
        }
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(enemyObject, 1200, 359);
        }
        if(textButton.gotClicked()) {
            changeHeroMode();
        }
         
    }
    
    public void changeHeroMode() {
        heroWithSword = new HeroWithSword();
        addObject(heroWithSword, 40, 200);
        removeObject(hero);
        scoreBoard.attach(heroWithSword);
        heroWithSword.registerObserver(scoreBoard);
        heroWithSword.displayWeaponCount();
    }
   
}