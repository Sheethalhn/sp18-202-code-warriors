import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    //private static final int GAME_SPEED = 50;
    private GreenfootSound backgroundMusic;  
    //private GifImage gif = new GifImage("blackback.gif");
    private ButtonPlay buttonPlay;
    private ButtonHelp buttonHelp;
    private ButtonStory buttonStory;
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    private StoryCommand storyCmd;
    protected GreenfootSound clicSound;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(1000, 600, 1); 
        backgroundMusic = new GreenfootSound("1.mp3");
        buttonPlay = new ButtonPlay();
        buttonHelp = new ButtonHelp();
        buttonStory = new ButtonStory();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
        storyCmd = new StoryCommand();
        prepare();
    }
    
    public void act()
    {
       //setBackground(gif.getCurrentImage());
       backgroundMusic.playLoop();
        //if(Greenfoot.mouseClicked(buttonPlay) && backgroundMusic.isPlaying())
           // backgroundMusic.stop();
    }
    
    /**
     * Place the buttons in the world
     */
    public void prepare()
    {
        addObject(buttonPlay, 600, 250);
        addObject(buttonHelp, 600, 350);
        addObject(buttonStory, 600, 450);        
        buttonPlay.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);
        buttonStory.setCommand(storyCmd);
        
        playCmd.setReceiver(
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonPlay)){
                        Greenfoot.setWorld(new Level0());
                    }
            }
           });
           
        helpCmd.setReceiver(
        new Receiver()
            {
                public void performAction()
                {
                        if(Greenfoot.mouseClicked(buttonHelp)){
                                Help help = buttonHelp.getHelp();
                                addObject(help, getWidth()/2, getHeight()/2);
                                        
                                addObject(new Back(help), 
                                                help.getX() - help.getImage().getWidth()/2,
                                                help.getY() - help.getImage().getHeight()/2);
                                
                            }
                }
           }
        );
        
        storyCmd.setReceiver(
        new Receiver()
            {
                public void performAction()
                {
                        if(Greenfoot.mouseClicked(buttonStory)){
                                Story story = buttonStory.getStory();
                                addObject(story, getWidth()/2, getHeight()/2);
                                        
                                addObject(new Back(story), 
                                                story.getX() - story.getImage().getWidth()/2,
                                                story.getY() - story.getImage().getHeight()/2);
                                
                            }
                }
           }
        );
    }
}
