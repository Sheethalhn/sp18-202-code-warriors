public class EnemyFactory  
{
    public Enemy EnemyCategory(int category)
    {
        Enemy newEnemy = null;
        if(category == 0)
        {
            RocketFactory newRocketFactory = new RocketFactory();
            newEnemy = newRocketFactory.makeEnemy();
            //return newEnemy;
        }
        
        else if(category == 1)
        {
            SwordFactory newSwordFactory = new SwordFactory();
            newEnemy = newSwordFactory.makeEnemy();
            //return newEnemy;
        }
        
        else if(category == 2)
        {
            FireFactory newFireFactory = new FireFactory();
            newEnemy = newFireFactory.makeEnemy();
            //return newEnemy;   
        }
        //else return newEnemy;
        return newEnemy; 
    }
}
