/* 
 * NotificationObserver.java
 * ENSF 480 - Project
 * 
 * John McMurtry 30087058
 * Athena McNeil-Roberts 30042085
 * Arindam Mishra-30092921
 * Harrison Mondragon 30088805
 */

import java.util.ArrayList;

public class NotificationObserver implements Observer {
    ArrayList<Property> prop;

    public void update(ArrayList<Property> p){
        this.prop = p;
    }

}
