package org.thor.javademo.enums;

/**
 * @Description: 类说明：加班费计算,工作日加班2倍，节假日3倍
 * @Author: wangyiqiang
 * @Date: 2020-02-03 下午7:09
 * @Version: V1.0
 */
public enum PayDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, WUYI;

    /**
     * 工作日
     */
    private static final int HOURS_WORK = 2;
    /**
     * 休息日
     */
    private static final int HOURS_REST = 3;

    /**
     * 超时时间
     *
     * @param hoursOvertime
     * @return
     */
    private double pay(double hoursOvertime) {
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                return hoursOvertime * HOURS_REST;
            default:
                return hoursOvertime * HOURS_WORK;
        }
    }
}
