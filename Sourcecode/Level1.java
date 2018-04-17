import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
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
    public int count = 0;

    public Level1()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels
        super(1200, 800, 1);
        hero = new Hero();
        scoreBoard =  new ScoreBoard();
        enemyObject = new EnemyObject();
        textButton = new Switch("SwitchMode");
        addObject(hero, 100, 200);
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
            count++;
            if (count % 2 != 0) {
                changeHeroSwordMode();
            }else{
                changeHeroMode();
            }
        }
         
    }
    
    public void changeHeroSwordMode() {
        heroWithSword = new HeroWithSword();
        addObject(heroWithSword, 100, 200);
        removeObject(hero);
        scoreBoard.attach(heroWithSword);
        heroWithSword.registerObserver(scoreBoard);
    }
    
    public void changeHeroMode() {
        addObject(hero, 100, 200);
        removeObject(heroWithSword);
        scoreBoard.attach(hero);
        hero.registerObserver(scoreBoard);
    }
   
}