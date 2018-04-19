/**
 * Write a description of class BatFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwordFactory extends EnemyFactory 
{
   public Enemy makeEnemy()
   {
       return new Sword();
   }
}
