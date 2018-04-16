/**
 * Write a description of class ISubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ISubject  
{
    void notifyObservers(int points);
    void registerObserver(IObserver o);
}
