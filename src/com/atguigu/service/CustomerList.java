package com.atguigu.service;
//内部封装一个Customer[],提供对Customer数据的增删改查操作

import com.atguigu.bean.Customer;

public class CustomerList {
	private Customer[] customers;
	private int total;//记录存储的客户的个数
	
	/**
	 * 构造器，用来初始化customers数组
	 * @param totalCustomer：指定customers数组的最大空间
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	
	/**
	 * 添加指定的客户到数组中
	 * @param customer
	 * @return 添加成功
	 */
	public boolean addCustomer(Customer customer) {
		if (customer != null && total < customers.length) {
			customers[total++] = customer;
			return true;
		}
		return false;
	}
	
	/**
	 * 替换指定索引位置上的数组元素
	 * @param index
	 * @param cust
	 * @return
	 */
	public boolean replaceCustomer(int index,Customer cust) {
		if(index >= 0 && index < total) {
			customers[index] = cust;
			return true;
		}
		return false;
		
	}
	
	
	/**
	 * 删除指定索引位置上的元素
	 * @param index
	 * @return
	 */
	public boolean deleteCustomer(int index) {
		if(index >= 0 && index < total) {
			for (int i = index; i < total - 1;i ++ ) {
				customers[i] = customers[i + 1];
			}
			customers[total - 1] = null;
			total --;
			//也可以写成下面这种形式
//			customers[total--] = null;
			return true;
		}
		return false;
	}
	
	/**
	 * 获取所有的customers对象构成的数组
	 * @return
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		//给数组元素赋值
		for(int i = 0; i < custs.length;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	/**
	 * 返回指定索引位置上的Customer
	 * @param index
	 * @return 如果输入的index位置上的元素不存在，返回null
	 */
	public Customer getCustomer(int index) {
		if (index > 0 && index < total) {
			return customers[index];
		}
		return null;
		
	}
	
	/**
	 * 返回Customer对象的个数
	 * @return
	 */
	public int getTotal() {
		return total;
	}
	
	

}
