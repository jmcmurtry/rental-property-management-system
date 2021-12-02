/* 
 * Subject.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

public interface Subject {
    public void register(Observer o);
    public void remove(Observer o);
    public void notifyObserver();
}
