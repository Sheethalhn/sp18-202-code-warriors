/**
 * Write a description of class FireFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireFactory extends EnemyFactory 
{
   public Enemy makeEnemy()
   {
       return new Fire();
   }
}
 