/**
 * Write a description of class BatFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatFactory extends EnemyFactory 
{
   public Enemy makeEnemy()
   {
       return new Bat();
   }
}
