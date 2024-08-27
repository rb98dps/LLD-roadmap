package creation.singleton;

public class EagerSingleton {

    private static final EagerSingleton singleton = new EagerSingleton();
    private EagerSingleton(){

    }
    public static EagerSingleton getSingleton(){
        return singleton;
    }
}
