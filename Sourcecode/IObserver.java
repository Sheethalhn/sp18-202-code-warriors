 /**
 * Write a description of class IObserver here.
 * 
 * @author (your name) 
* @version (a version number or a date)
*/
public interface IObserver  
{
    void attach(ISubject subject);
    void detach(ISubject subject);
    
}
