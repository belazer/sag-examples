class Client {

  public static void main(String[] args) {
    /*
    * Struktur aufbauen
    */
    Composite rootComposite = new Composite();
    rootComposite.add(new Leaf());
    rootComposite.add(new Leaf());

    Composite otherCmposite = new Composite();
    rootComposite.add(otherCmposite);

    otherCmposite.add(new Leaf());
    otherCmposite.add(new Leaf());
    otherCmposite.add(new Leaf());

    /*
    * Einfache Nutzung der Struktur
    */
    rootComposite.opertation();

  }
}
