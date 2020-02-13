package org.thor.javademo.enums;

/**
 * @Description: 类说明：加班费计算,工作日加班2倍，节假日3倍
 * @Author: wangyiqiang
 * @Date: 2020-02-03 下午7:09
 * @Version: V1.0
 */
public enum BetterPayDay {
    MONDAY(PayType.WORK), TUESDAY(PayType.WORK), WEDNESDAY(
            PayType.WORK), THURSDAY(PayType.WORK), FRIDAY(PayType.WORK),
    SATURDAY(PayType.REST), SUNDAY(PayType.REST), WUYI(PayType.REST);

    /**
     * 成员变量
     */
    private final PayType payType;

    BetterPayDay(PayType payType) {
        this.payType = payType;
    }

    private double pay(double hoursOvertime) {
        return payType.pay(hoursOvertime);
    }

	/**
	 * 策略枚举
	 */
	private enum PayType {
        WORK {
            @Override
			double pay(double hoursOvertime) {
                return hoursOvertime * HOURS_WORK;
            }
        },
        REST {
            @Override
			double pay(double hoursOvertime) {
                return hoursOvertime * HOURS_REST;
            }
        };

        private static final int HOURS_WORK = 2;
        private static final int HOURS_REST = 3;

		/**
		 * 抽象计算加班费的方法
		 * @param hoursOvertime
		 * @return
		 */
        abstract double pay(double hoursOvertime);
    }

    public static void main(String[] args) {
        System.out.println(BetterPayDay.MONDAY.pay(7.5));
    }
}