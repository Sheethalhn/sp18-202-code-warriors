import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor implements IObserver
{
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ISubject subject;
    private int score;
    private static ScoreBoard sb;
    
    
    public static ScoreBoard getInstance(){
        if(sb == null)
            sb = new ScoreBoard();
            
        return sb;
            
    }
    
    private ScoreBoard() {
        score = 0;
        //GreenfootImage scoreBoardImage = getImage();
        //scoreBoardImage.scale(scoreBoardImage.getWidth(), scoreBoardImage.getHeight());
        //setImage(scoreBoardImage);
    }
    public void act() 
    {
        showScore();
    }    
    private void showScore()
    {
        getWorld().showText("Score: " + score, 900, 35);
    }
    public void addScore(int points){
        score+=points;
    }
    public void attach(ISubject s){
        subject = s;
    }
    
    public void detach(ISubject s){
        subject = null;
    }
}
