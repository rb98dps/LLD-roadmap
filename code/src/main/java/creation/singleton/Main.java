package creation.singleton;

public class Main {

    public static void main(String[] args) {
        BadSingleton badSingleton = BadSingleton.getSingleton();
        LazySingleton lazySingleton = LazySingleton.getSingleton();
        EagerSingleton eagerSingleton = EagerSingleton.getSingleton();
    }
}
