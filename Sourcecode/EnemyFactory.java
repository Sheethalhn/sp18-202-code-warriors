  public abstract class EnemyFactory  
{
    public abstract Enemy makeEnemy();
    
    public Enemy EnemyCategory()
    {
        Enemy newEnemy = null;
        newEnemy=makeEnemy();
        return newEnemy; 
    }
}
