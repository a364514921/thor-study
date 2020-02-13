package org.thor.javademo.design_pattern.factory.sample_factory;


import org.thor.javademo.design_pattern.factory.Circle;
import org.thor.javademo.design_pattern.factory.Rectangle;
import org.thor.javademo.design_pattern.factory.Square;

public class Test2 {
    public static void main(String[] args) {

        Circle circle = (Circle) ShapeFactory2.getClass(Circle.class);
        circle.draw();

        Rectangle rectangle = (Rectangle) ShapeFactory2.getClass(Rectangle.class);
        rectangle.draw();

        Square square = (Square) ShapeFactory2.getClass(Square.class);
        square.draw();
    }

}
