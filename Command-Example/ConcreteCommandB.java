class ConcreteCommandB implements Command {
  private ReceiverA receiverB;

  public ConcreteCommandB(ReceiverB receiver) {
    this.receiverB = receiver;
  }

  public void execute() {
    receiverB.action1();
  }
}
