package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.DaoException;

import utils.BeanDataUtil;
import utils.JdbcUtil;

import dao.Dao_customerInter;
import domain.Customer;

public class Dao_customer implements Dao_customerInter {
	
	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#insert(domain.Customer)
	 */
	public void insert(Customer customer){
		
		Connection con=null;
		PreparedStatement ps=null;
		
		con=JdbcUtil.getCon();
		String sql="insert into customer values(?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			
			customer.setPassword(BeanDataUtil.ensecret(customer.getPassword()));
			ps.setObject(1, customer.getId());
			ps.setObject(2, customer.getName());
			ps.setObject(3, customer.getGender());
			ps.setObject(4, customer.getBirthday());
			ps.setObject(5, customer.getCellphone());
			ps.setObject(6, customer.getEmail());
			ps.setObject(7, customer.getPreferences());
			ps.setObject(8, customer.getTypes());
			ps.setObject(9, customer.getDescription());
			ps.setObject(10, customer.getPassword());
			
			ps.execute();
			
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#delete(java.lang.String)
	 */
	public void delete(String id){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=JdbcUtil.getCon();
		String sql="delete from customer where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setObject(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(con, ps, rs);
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#update(domain.Customer)
	 */
	public void update(Customer customer){
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=JdbcUtil.getCon();
		String sql="update customer set name=?," +
				"gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=?,password=? where id=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			customer.setPassword(BeanDataUtil.ensecret(customer.getPassword()));
			ps.setObject(1, customer.getName());
			ps.setObject(2, customer.getGender());
			ps.setObject(3, customer.getBirthday());
			ps.setObject(4, customer.getCellphone());
			ps.setObject(5, customer.getEmail());
			ps.setObject(6, customer.getPreferences());
			ps.setObject(7, customer.getTypes());
			ps.setObject(8, customer.getDescription());
			ps.setObject(9, customer.getPassword());
			ps.setObject(10, customer.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(con, ps, rs);
		}
		
		
		
		
	}
	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#listCustomer()
	 */
	public List<Customer> listCustomer(){
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=JdbcUtil.getCon();
		String sql="select * from customer";
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			List<Customer>list=new ArrayList<Customer>();
			
			while(rs.next()){
				Customer customer=new Customer();
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBirthday(rs.getDate("birthday"));
				customer.setCellphone(rs.getString("cellphone"));
				customer.setEmail(rs.getString("email"));
				customer.setPreferences(rs.getString("preference"));
				customer.setTypes(rs.getString("type"));
				customer.setDescription(rs.getString("description"));
				customer.setPassword(rs.getString("password"));
				
				list.add(customer);
			}
			
			return list;
			
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(con, ps, rs);
		}
		
	}
	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#getPageData(int, int)
	 */
	public List<Customer> getPageData(int startindex,int pagesize){
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=JdbcUtil.getCon();
		String sql="select * from customer limit ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setObject(1, startindex);
			ps.setObject(2, pagesize);
			
			rs=ps.executeQuery();
			List<Customer>list=new ArrayList<Customer>();
			
			while(rs.next()){
				Customer customer=new Customer();
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBirthday(rs.getDate("birthday"));
				customer.setCellphone(rs.getString("cellphone"));
				customer.setEmail(rs.getString("email"));
				customer.setPreferences(rs.getString("preference"));
				customer.setTypes(rs.getString("type"));
				customer.setDescription(rs.getString("description"));
				customer.setPassword(rs.getString("password"));
				
				list.add(customer);
			}
			
			return list;
			
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(con, ps, rs);
		}
		
	}
	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#getTatalRecord()
	 */
	public int getTatalRecord(){
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=JdbcUtil.getCon();
		String sql="select count(*) from customer ";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()){
				return Integer.parseInt(rs.getString(1));
			}
			
			return 0;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(con, ps, rs);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.Dao_customerInter#find(java.lang.String)
	 */
	public Customer find(String id){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=JdbcUtil.getCon();
		String sql="select * from customer where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setObject(1, id);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				Customer customer=new Customer();
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setBirthday(rs.getDate("birthday"));
				customer.setCellphone(rs.getString("cellphone"));
				customer.setEmail(rs.getString("email"));
				customer.setPreferences(rs.getString("preference"));
				customer.setTypes(rs.getString("type"));
				customer.setDescription(rs.getString("description"));
				customer.setPassword(rs.getString("password"));
				
				return customer;
				
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(con, ps, rs);
		}
		return null;
	}
}
