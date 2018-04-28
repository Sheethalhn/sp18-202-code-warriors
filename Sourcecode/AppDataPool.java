/**
 * Write a description of class AppDataPool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppDataPool  
{
    // instance variables - replace the example below with your own
    private HealthScore healthScore;
    private static  AppDataPool appDataPool;
    
    public static AppDataPool getInstance(){
        if(appDataPool == null)
            appDataPool = new AppDataPool();
        return appDataPool;
    }
    
    public void setHealthScore(HealthScore hc){
        healthScore = hc;
    }
    public HealthScore getHealthScore(){
        return healthScore;
    }
    /**
     * Constructor for objects of class AppDataPool
     */
    private AppDataPool()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return 0;
    }
}
