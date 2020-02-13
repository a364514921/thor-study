package org.thor.javademo.design_pattern.factory.factory_method;


import org.thor.javademo.design_pattern.factory.Circle;
import org.thor.javademo.design_pattern.factory.Shape;

public class CircleFactory implements Factory {

    @Override
    public Circle getShape() {
        // TODO Auto-generated method stub
        return new Circle();
    }

}
