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
    private TChalla tChalla;
    private ScoreBoard scoreBoard;
    private Rocket rocket;
    private Fire fire;
    private Sword sword;
    private Star star;
    public int count = 0;
    GreenfootSound backgroundMusic = new GreenfootSound("1.mp3");
    private static final String bgImageName = "wakanda2.jpg";    //level1
    private static final double scrollSpeed = 5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private int counter = 0;
    private HealthScore healthScore;


    public Level1()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels
        super(1000, 600, 1, false);
        setBackground(bgImageName);
        backgroundMusic.playLoop();
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        
        tChalla = new TChalla();
        scoreBoard =  ScoreBoard.getInstance();
        healthScore = AppDataPool.getInstance().getHealthScore();
        rocket = new Rocket();
        fire = new Fire();
        sword = new Sword();
        star = new Star();
        addObject(tChalla, 100, 200);
        addObject(scoreBoard, 850, 35);
        addObject(healthScore,750,35);
        scoreBoard.attach(tChalla);
        
        healthScore.attach(tChalla);
        tChalla.registerObserver(scoreBoard);
        tChalla.registerObserver(healthScore);

        
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
        
        if(counter>=70)
        {
            createEnemy();
            counter=0;
            count++;
        }
            
  
       // if(textButton.gotClicked()) {
       //     count++; 
       //     if (count % 2 != 0) {
       //         changeHeroSwordMode();
       //     }else{
       //         changeHeroMode();
       //     }
       // }
        if (count <= 5) {
            addObject((Players)star, getWidth(), Greenfoot.getRandomNumber(600)); 
        }
         if (tChalla != null) {
           if (tChalla.stopGameForScore(scoreBoard.getScore())){
               
               scoreBoard.setScore(0);
               removeObject(scoreBoard);
            }
            if(tChalla.stopGame()) {
                
                scoreBoard.setScore(0);
                removeObject(scoreBoard);
        }
    }
    }
    
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    } 
    
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
  
       }  


        
    }
   
}