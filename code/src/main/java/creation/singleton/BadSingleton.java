package creation.singleton;

public class BadSingleton {

    private static BadSingleton singleton;

    private BadSingleton(){

    }
    public static synchronized BadSingleton getSingleton() {
        if(singleton==null){
            singleton = new BadSingleton();
        }
        return singleton;
    }
}
