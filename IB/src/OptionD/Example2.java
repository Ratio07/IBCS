package OptionD;

public class Example2 {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = (Circle)shape.create();
    }
}

class Shape{
    Shape create(){
        return new Shape();
    }
}

class Circle extends Shape{
    Circle create(){
        return new Circle();
    }
}

