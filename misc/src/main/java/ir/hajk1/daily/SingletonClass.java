package ir.hajk1.daily;

import java.util.Random;

public class SingletonClass {

    private static volatile SingletonClass sSoleInstance;
    public int random;

    //private constructor.
    private SingletonClass() {
        //Prevent from the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        random = new Random().nextInt(1000);
        Thread.yield();
    }

    public static SingletonClass getInstance() {
        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time
            synchronized (SingletonClass.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) {
                    sSoleInstance = new SingletonClass();
                }
            }
        }
        return sSoleInstance;
    }

}
