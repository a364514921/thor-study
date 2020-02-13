package org.thor.javademo.demo.unit_3;

import java.io.File;

/**
 * 文件操作
 * 模块名称：StudyJava com.wyq.studyjava.demo.unit_3
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-23 上午6:20
 * 系统版本：1.0.0
 **/

public class FileListDemo {
    public static void main(String[] args) {
        File[] files = File.listRoots();
        System.out.println(files.length);

        String filename = String.format("phone%.2f", 25.236);

        System.out.println(filename);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
