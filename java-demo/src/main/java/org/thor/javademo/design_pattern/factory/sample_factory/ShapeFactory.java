package org.thor.javademo.design_pattern.factory.sample_factory;


import org.thor.javademo.design_pattern.factory.Circle;
import org.thor.javademo.design_pattern.factory.Rectangle;
import org.thor.javademo.design_pattern.factory.Shape;
import org.thor.javademo.design_pattern.factory.Square;

public class ShapeFactory {

    // 使用 getShape 方法获取形状类型的对象
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}