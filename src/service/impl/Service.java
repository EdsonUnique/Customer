package service.impl;

import java.util.List;

import service.ServiceInter;
import utils.BeanDataUtil;
import utils.daoUtil;

import Exceptions.CustomerExistsException;

import dao.Dao_customerInter;
import dao.impl.Dao_customer;
import domain.Customer;
import domain.Page;

public class Service implements ServiceInter {
	
	private static Dao_customerInter dao=daoUtil.getDao();

	/* (non-Javadoc)
	 * @see service.impl.ServiceInter#add(domain.Customer)
	 */
	public void add(Customer customer){
		
		if(dao.find(customer.getId())==null){
			dao.insert(customer);
		}else{
			throw new CustomerExistsException("用户已存在！");
		}
	}
	
	/* (non-Javadoc)
	 * @see service.impl.ServiceInter#delete(java.lang.String)
	 */
	public void delete(String id ){
		dao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.ServiceInter#listAllCustomer()
	 */
	public List<Customer> listAllCustomer(){
		return dao.listCustomer();
	}
	
	/* (non-Javadoc)
	 * @see service.impl.ServiceInter#find(java.lang.String)
	 */
	public Customer find(String id){
		return dao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.ServiceInter#getPageData(java.lang.String)
	 */
	public Page getPageData(String pagenum){
		int pagerecord=dao.getTatalRecord();
		Page page=null;
		
		if(pagenum==null){
			
			page=new Page(1,pagerecord);
		}else{
			
			page=new Page(Integer.parseInt(pagenum),pagerecord);			
		}
		
		
		page.setList(dao.getPageData(page.getStartindex(), page.getPagesize()));
		
		return page;
		
	}

	/* (non-Javadoc)
	 * @see service.impl.ServiceInter#update(domain.Customer)
	 */
	public void update(Customer customer) {
		dao.update(customer);
	}
	
}
