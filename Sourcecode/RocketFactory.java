/**
 * Write a description of class RocketFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketFactory extends EnemyFactory 
{
   public Enemy makeEnemy()
   {
       return new Rocket();
   }
}

