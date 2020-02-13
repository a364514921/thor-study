package org.thor.javademo.design_pattern.factory.abstract_factory;

public class AK_Bullet implements Bullet {

    @Override
    public void load() {
        System.out.println("Load bullets with AK");
    }

}
