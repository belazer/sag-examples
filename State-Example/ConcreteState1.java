class ConcreteState1 implements State {
  public void operate() {
    System.out.println("ConcreteState1");
    //ggf. Zustandswechsel, dazu Handle auf Context mit entsprechenden Setter notwendig
  }
}
