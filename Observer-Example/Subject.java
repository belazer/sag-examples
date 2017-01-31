public abstract class Subject {

  private final List observerList = new ArrayList();

  public void register(Observer newObserver) {
    observerList.add(newObserver);
  }

  public void unregister(Observer newObserver) {
    observerList.remove(newObserver);
  }

  public void notifyObservers(int state) {
    for (Observer observer : observerList) {
      observer.update(state);
    }
  }
}
