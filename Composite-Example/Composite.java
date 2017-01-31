class Composite extends Component {

  //Components als Liste gehalten
  private List childComponents = new ArrayList();

  //rekursiver Aufruf von childComponent
  public void operation() {
    System.out.println("Ich bin ein Composite. Meine Kinder sind: ");
    for (Component childComps : childComponents) {
      childComps.operation();
    }
  }

  //Defaultimplementierungen überschrieben
  public void add(Component comp) {
    childComponents.add(comp);
  }

  public void remove(Component comp) {
    childComponents.remove(comp);
  }

  public Component getChild(int index) {
    return childComponents.get(index);
  }
}
