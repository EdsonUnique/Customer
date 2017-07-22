package service;

import java.util.List;

import domain.Customer;
import domain.Page;

public interface ServiceInter {

	public void add(Customer customer);

	public void delete(String id);

	public List<Customer> listAllCustomer();

	public Customer find(String id);

	public Page getPageData(String pagenum);

	public void update(Customer customer);

}