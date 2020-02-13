package org.thor.javademo.design_pattern.factory.factory_method;


import org.thor.javademo.design_pattern.factory.Shape;
import org.thor.javademo.design_pattern.factory.Square;

public class SquareFactory implements Factory{

    @Override
    public Shape getShape() {
        // TODO Auto-generated method stub
        return new Square();
    }

}
