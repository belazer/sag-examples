public static void main(String[] args) {
    //zentraler Austauschpunkt -> Implementierungsaustausch
    AbstractFactory factory = new ConcreteFactoryA();
    
    IProduct1 product1 = factory.createProduct1(); //product1-implementierung von ConcreteFactoryA
    IProduct2 product2 = factory.createProduct2(); //product2-implementierung von ConcreteFactoryA
    IProduct3 product3 = factory.createProduct3(); //product3-implementierung von ConcreteFactoryA
}
