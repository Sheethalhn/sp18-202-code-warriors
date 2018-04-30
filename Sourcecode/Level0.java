     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level0 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private ObjectEnemy objectEnemy;
    private HealthScore healthScore;
    private Rocket rocket;
    private Fire fire;
    private Sword sword;
    //private Switch textButton = null;
    public int count = 0;
    GreenfootSound backgroundMusic = new GreenfootSound("1.mp3");
    private static final String bgImageName = "wakanda1.png";    //level1
    private static final double scrollSpeed = 5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private int counter = 0;
    private int enemyobjectCount = 0;

   
    public Level0()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels
        
        super(1000, 600, 1, false);
        setBackground(bgImageName);
        backgroundMusic.playLoop();
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        objectEnemy = new ObjectEnemy();
        healthScore =  new HealthScore();
        //setBackground(hero.getCurrentImage());
        
        fire = new Fire();
        sword = new Sword();
        rocket = new Rocket();
        //textButton = new Switch("SwitchMode");
        addObject(objectEnemy, 100, 200);
        addObject(healthScore, 850, 35);
        //addObject(textButton, 600, 35);
        healthScore.attach(objectEnemy);
        objectEnemy.registerObserver(healthScore);
    }
    public void act() { 
        

       
        if(!backgroundMusic.isPlaying())
        {
            backgroundMusic.playLoop();
        
        }
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition); 
        counter++;
        
        if(counter>=20)
        {
            createEnemy();
            counter=0;
        }
        
          
    }
    
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    } 
    /*
     public void createFire()
    {
        FireFactory theFireFactory = new FireFactory();
        Enemy theEnemy = null;       
        int category = Greenfoot.getRandomNumber(3);
       
           theEnemy = theFireFactory.EnemyCategory(category);           
           addObject(theEnemy, getWidth(), Greenfoot.getRandomNumber(600));
           enemyobjectCount++;
       } 
    
    public void createGem()
    {
        GemFactory theGemFactory = new GemFactory();
        Enemy theEnemy2 = null;       
        int category = Greenfoot.getRandomNumber(3);if(category >= 0)
       {
           theEnemy2 = theEnemyFactory.EnemyCategory(category);           
           addObject(theEnemy, getWidth(), Greenfoot.getRandomNumber(600));
           enemyobjectCount++;
       }    
       */
      
       //Switch to Next Level - Level 1
    public void createEnemy()
    {
        
      

        Enemy theEnemy = null;       
        int category = Greenfoot.getRandomNumber(3);
       if(category >= 0)
       {
        if(category == 0)
        {
            RocketFactory newRocketFactory = new RocketFactory();
            theEnemy = newRocketFactory.EnemyCategory();
            //return newEnemy;
        }
        
        else if(category == 1)
        {
            SwordFactory newSwordFactory = new SwordFactory();
            theEnemy = newSwordFactory.EnemyCategory();
            //return newEnemy;
        }
        
        else if(category == 2)
        {
            FireFactory newFireFactory = new FireFactory();
            theEnemy = newFireFactory.EnemyCategory();
            //return newEnemy;   
        }        
           addObject((Players)theEnemy, getWidth(), Greenfoot.getRandomNumber(600)); 
           enemyobjectCount++;
       }  

       if(enemyobjectCount==20)
       {
           AppDataPool.getInstance().setHealthScore(healthScore);
           Greenfoot.setWorld(new Level1help());
           
       }
        //rocket.setImage("rocket.png");
        
        
    }
   
}
