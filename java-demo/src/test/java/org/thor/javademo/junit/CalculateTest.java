package org.thor.javademo.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 模块名称：StudyJava junit
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2017-12-12 上午5:31
 * 系统版本：1.0.0
 **/

public class CalculateTest {

    @Test
    public void testSum() {
        Calculate calculate = new Calculate();
        int sum = calculate.sum(2, 5);
        int testSum = 7;
        System.out.println("@Test sum(): " + sum + " = " + testSum);
        assertEquals(sum, testSum);
    }


}
