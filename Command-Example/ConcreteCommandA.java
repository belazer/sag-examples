class ConcreteCommandA implements Command {
  private ReceiverA receiverA;

  public ConcreteCommandA(ReceiverA receiver) {
    this.receiverA = receiver;
  }

  public void execute() {
    receiverA.action1();
    receiverA.action2();
  }
}
