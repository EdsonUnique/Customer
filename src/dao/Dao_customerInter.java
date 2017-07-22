package dao;

import java.util.List;

import domain.Customer;

public interface Dao_customerInter {

	public void insert(Customer customer);

	public void delete(String id);

	public void update(Customer customer);

	/**
	 * �г����пͻ���¼
	 * @return
	 */
	public List<Customer> listCustomer();

	/**
	 * ����ҳ��������Ӧ�ͻ���
	 * @param startindex
	 * @param pagesize
	 * @return
	 */
	public List<Customer> getPageData(int startindex, int pagesize);

	/**
	 * ��ȡ�ܿͻ���¼��
	 * @return
	 */
	public int getTatalRecord();

	public Customer find(String id);

}