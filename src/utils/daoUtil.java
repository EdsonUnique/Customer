package utils;



import java.util.Properties;

import dao.Dao_customerInter;

public class daoUtil {

	private static Dao_customerInter dao=null;
	
	static{
		
		Properties pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties"));
			String dao_type=pros.getProperty("dao_type");
	
			dao=(Dao_customerInter) Class.forName(dao_type).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public static Dao_customerInter getDao(){
		return dao;
	}
}
