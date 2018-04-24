/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter  
{
    private long lastWeapon= System.currentTimeMillis(); 
    
    public void timer()
    {
        lastWeapon = System.currentTimeMillis();
    }
    
    /**
     * Returns the amount of milliseconds that have elapsed since shot()
     * was last called.  This timer runs irrespective of Greenfoot's
     * act() cycle, so if you call it many times during the same Greenfoot frame,
     * you may get different values returned.
     */
    public int timeElapsed()
    {
        return (int) (System.currentTimeMillis() - lastWeapon);
    }
}
 