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
    private Fighter fighter;
    private ScoreBoard scoreBoard;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        fighter = new Fighter();
        scoreBoard =  new ScoreBoard();
        addObject(fighter, 40, 200);
        addObject(scoreBoard, 520, 35);
        scoreBoard.attach(fighter);
        fighter.registerObserver(scoreBoard);    
       
    }
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new AttackObject(), 779, Greenfoot.getRandomNumber(360));
        }
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new AttackObject(), 779, 359);
        }
         
    }
    
}