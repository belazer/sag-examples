class ConcreteFactoryB implements AbstractFactory{
    @Override
    public Product1 createProduct1() {
        return new ConcreteProduct1B();
    }

    @Override
    public Product2 createProduct2() {
        return new ConcreteProduct2B();
    }

    @Override
    public Product3 createProduct3() {
        return new ConcreteProduct3B();
    }
}
