package OptionD;

public class Example3 {
   // QSI qsi = new QSI(); does not work
}

abstract class QSI{
    //cannot create object of abstract class
    abstract void welcomeMessage();
}

class QSI_Sec extends QSI{
    @Override
    void welcomeMessage() {
        System.out.println("Welcome to QSI Secondary");
    }
}
