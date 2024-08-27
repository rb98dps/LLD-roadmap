package creation.observerPattern;

public class Main {
    public static void main(String[] args) {
        Observer ob1 = new Observer1();
        Observer ob2 = new Observer2();
        Publisher publisher = Publisher.publisher;
        publisher.addObserver(ob1);
        publisher.addObserver(ob2);

        publisher.updateAll();
    }
}
