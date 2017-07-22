package dao;

import java.util.List;

import domain.Customer;

public interface Dao_customerInter {

	public void insert(Customer customer);

	public void delete(String id);

	public void update(Customer customer);

	/**
	 * 列出所有客户记录
	 * @return
	 */
	public List<Customer> listCustomer();

	/**
	 * 根据页数返回相应客户数
	 * @param startindex
	 * @param pagesize
	 * @return
	 */
	public List<Customer> getPageData(int startindex, int pagesize);

	/**
	 * 获取总客户记录数
	 * @return
	 */
	public int getTatalRecord();

	public Customer find(String id);

}