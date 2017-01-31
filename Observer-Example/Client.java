public class Client {

  public static void main(String[] args) {
    ConcreteSubject concreteSubject = new ConcreteSubject();
    concreteSubject.register(new ConcreteObserverA());
    concreteSubject.register(new ConcreteObserverB());

    concreteSubject.setState(77);
    //Concrete Observer A updated with 77
    //Concrete Observer B updated with 77

  }
}
