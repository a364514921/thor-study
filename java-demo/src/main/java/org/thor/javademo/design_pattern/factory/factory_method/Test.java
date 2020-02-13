package org.thor.javademo.design_pattern.factory.factory_method;


import org.thor.javademo.design_pattern.factory.Shape;

public class Test {

    public static void main(String[] args) {
        Factory circlefactory = new CircleFactory();
        Shape circle = circlefactory.getShape();
        circle.draw();
    }

}
