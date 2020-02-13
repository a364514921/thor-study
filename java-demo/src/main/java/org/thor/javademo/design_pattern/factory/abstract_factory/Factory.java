package org.thor.javademo.design_pattern.factory.abstract_factory;

public interface Factory {
    public Gun produceGun();
    public Bullet produceBullet();
}