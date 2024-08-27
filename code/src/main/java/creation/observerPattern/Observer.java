package creation.observerPattern;

public interface Observer {
    void update();
}

class Observer1 implements Observer{
    public void update(){
        System.out.println("Got the message Observer1");
    }
}

class Observer2 implements Observer{
    public void update(){
        System.out.println("Got the message Observer2");
    }
}
