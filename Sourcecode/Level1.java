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
    private BlackPanther blackPanther;
    private ScoreBoard scoreBoard;
    private Rocket rocket;
    private Fire fire;
    private Sword sword;
    private Switch textButton = null;
    public int count = 0;
    GreenfootSound backgroundMusic = new GreenfootSound("1.mp3");
    private static final String bgImageName = "Wakandaimage.jpg";    //level1
    private static final double scrollSpeed = 5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private int counter = 0;


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
        scoreBoard =  new ScoreBoard();
        rocket = new Rocket();
        fire = new Fire();
        sword = new Sword();
        textButton = new Switch("SwitchMode");
        addObject(tChalla, 100, 200);
        addObject(scoreBoard, 850, 35);
        addObject(textButton, 600, 35);
        scoreBoard.attach(tChalla);
        tChalla.registerObserver(scoreBoard);
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
            
  
        if(textButton.gotClicked()) {
            count++; 
            if (count % 2 != 0) {
                changeHeroSwordMode();
            }else{
                changeHeroMode();
            }
        }
          
    }
    
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    } 
    
    public void changeHeroSwordMode() {
        blackPanther = new BlackPanther();
        addObject(blackPanther, 100, 200);
        removeObject(tChalla);
        scoreBoard.attach(blackPanther);
        blackPanther.registerObserver(scoreBoard);
    }
    
    public void changeHeroMode() {
        addObject(tChalla, 100, 200); 
        removeObject(blackPanther);
        scoreBoard.attach(tChalla);
        tChalla.registerObserver(scoreBoard);
    }
    
    public void createEnemy()
    {
        EnemyFactory theEnemyFactory = new EnemyFactory();
        Enemy theEnemy = null;       
        int category = Greenfoot.getRandomNumber(3);
       if(category >= 0)
       {
           theEnemy = theEnemyFactory.EnemyCategory(category);           
           addObject(theEnemy, getWidth(), Greenfoot.getRandomNumber(600));           
       }    
        
        
    }
   
}