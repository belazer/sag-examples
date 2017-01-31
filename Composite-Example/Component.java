abstract class Component {

  //gemeinsame Methode
  public abstract void operation();

  public void add(Component comp) {
    //Leere Defaultimplementierung
    //Für Leafs nicht sinnoll.
    //Werden nur von Composites überschrieben
  }

  public void remove(Component comp) {
    //Leere Defaultimpl.
  }

  public Component getChild(int index) {
    //Leere Defaultimpl
    return null;
  }
}
