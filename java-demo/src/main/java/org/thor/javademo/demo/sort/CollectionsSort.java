package org.thor.javademo.demo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * TODO Collections类方法测试之排序
 * @author 寇爽
 * @date 2017年11月20日
 * @version 1.8
 */
public class CollectionsSort {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(-1);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(-5);
		arrayList.add(7);
		arrayList.add(4);
		arrayList.add(-9);
		arrayList.add(-7);
		System.out.println("原始数组:");
		System.out.println(arrayList);
		// void reverse(List list)：反转
		Collections.reverse(arrayList);
		System.out.println("Collections.reverse(arrayList):");
		System.out.println(arrayList);
/*		
		 * void rotate(List list, int distance),旋转。
		 * 当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将
		 * list的前distance个元素整体移到后面。
		 
		Collections.rotate(arrayList, 4);
		System.out.println("Collections.rotate(arrayList, 4):");
		System.out.println(arrayList);*/
		
		// void sort(List list),按自然排序的升序排序
		Collections.sort(arrayList);
		System.out.println("Collections.sort(arrayList):");
		System.out.println(arrayList);

		// void shuffle(List list),随机排序
		Collections.shuffle(arrayList);
		System.out.println("Collections.shuffle(arrayList):");
		System.out.println(arrayList);

		// 定制排序的用法
		Collections.sort(arrayList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println("定制排序后：");
		System.out.println(arrayList);
	}

}