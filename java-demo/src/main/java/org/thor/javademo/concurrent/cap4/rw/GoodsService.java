package org.thor.javademo.concurrent.cap4.rw;

/**
 *类说明：商品的服务的接口
 */
public interface GoodsService {

	/**
	 * 获得商品的信息
	 * @return
	 */
	public GoodsInfo getNum();

	/**
	 * 设置商品的数量
	 * @param number
	 */
	public void setNum(int number);
}
