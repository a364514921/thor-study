package org.thor.javademo.design_pattern.factory.factory_method;


import org.thor.javademo.design_pattern.factory.Rectangle;
import org.thor.javademo.design_pattern.factory.Shape;

public class RectangleFactory implements Factory{

    @Override
    public Shape getShape() {
        // TODO Auto-generated method stub
        return new Rectangle();
    }

}
