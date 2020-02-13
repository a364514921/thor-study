package org.thor.javademo.design_pattern.adapter;

public class Adapter2Main {

    public static void main(String[] args) {
        // 使用特殊功能类，即适配类
        Target adapter = new M5DataLineAdapter2(new M5DataLine());
        adapter.connection();
    }
}