public class ConcreteSubject extends Subject {

  public int state;

  public void setState(int state) {
    this.state = state;
    //Jetzt alle Observer benachrichtigen
    notifyObservers(state);
  }

  public int getState() {
    return state;
  }
}
