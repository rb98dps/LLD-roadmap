package creation.singleton;

public class LazySingleton {


    //volatile makes the threads to be in sync of the operation. difference is that it does not guarantee atomicity
    private static volatile LazySingleton singleton;

    private LazySingleton(){

    }
    public static LazySingleton getSingleton(){
        if(singleton==null){
            synchronized (LazySingleton.class){
                if(singleton==null){
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
