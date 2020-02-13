package org.thor.javademo.design_pattern.adapter;

public class AdapterMain {

    public static void main(String[] args) {
        Target target = new M5DataLine();
        target.connection();

        Target adapter = new M5DataLineAdapter();
        adapter.connection();
    }
}