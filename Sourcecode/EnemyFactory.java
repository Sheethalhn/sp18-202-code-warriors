public class EnemyFactory  
{
    public Enemy EnemyCategory(int category)
    {
        Enemy newEnemy = null;
        if(category == 0)
        {
            RocketFactory newFighterFactory = new RocketFactory();
            newEnemy = newFighterFactory.makeEnemy();
            //return newEnemy;
        }
        
        else if(category == 1)
        {
            BatFactory newColonelFactory = new BatFactory();
            newEnemy = newColonelFactory.makeEnemy();
            //return newEnemy;
        }
        
        else if(category == 2)
        {
            FireFactory newCaptainFactory = new FireFactory();
            newEnemy = newCaptainFactory.makeEnemy();
            //return newEnemy;   
        }
        //else return newEnemy;
        return newEnemy; 
    }
}
