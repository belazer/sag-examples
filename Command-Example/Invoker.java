//dieser Invoker ist mit einer Reihe von Befehlen geladen
//je nach Methodenaufruf wird eins davon augelöst
class Invoker{
    private Command command1; //default möglich
    private Command command2; //default möglich

    //Eine Variante: Methode, die für Auführung des Befehls sorgt.
    //kann z. B. durch ein Event ausgelöst werden
    public void doCommand1(){
        command1.execute();
    }
    public void doCommand2(){
        command2.execute();
    }

    //Methode, mit der der Invoker konfiguriert werden kann
    //bzw. mit der die Commands geladen werden
    public void setCommand1(Command command1) {
        this.command1 = command1;
    }

    public void setCommand2(Command command2) {
        tnis.command2 = command2;
    }
}
