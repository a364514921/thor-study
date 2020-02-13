package org.thor.javademo.demo.unit_1;

/**
 * 模块名称：StudyJava com.wyq.studyjava.demo.unit_1
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-01-30 13:03
 * 系统版本：1.0.0
 **/

public class Father {
    private Integer userId;

    private String username;

    private Short age;

    public Father() {
    }

    public Father(Integer userId, String username, Short age) {
        this.userId = userId;
        this.username = username;
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}