package org.thor.javademo.thread.notyfy_wait;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.notyfy_wait
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-08-19 上午8:22
 * 系统版本：1.0.0
 **/

public class MyList {
    private static List<String> list = new ArrayList<>();

    public static void  add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
