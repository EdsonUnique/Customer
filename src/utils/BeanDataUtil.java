package utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.sun.org.apache.commons.beanutils.Converter;

public class BeanDataUtil {

	public static <T> T request2bean(HttpServletRequest request,Class<T> clazz){
		
		try{
			T t=clazz.newInstance();
			
			Enumeration e=request.getParameterNames();
			
			ConvertUtils.register(new Converter(){

				public Object convert(Class clazz, Object object) {
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					try {
						return df.parse((String) object);
					} catch (ParseException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
					
					
				}
				
				
			}, Date.class);
			
			while(e.hasMoreElements()){
				
				String name=(String) e.nextElement();
				String value=request.getParameter(name);
				
				BeanUtils.setProperty(t, name, value);
				
			}
			
			return t;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * 产生id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString();
	}
	/**
	 * 对客户密码进行md5加密
	 * 产生表单号防止重复提交name+password
	 * @param str
	 * @return
	 */
	public static String ensecret(String str){
		
		MessageDigest d;
		try {
			d = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		byte message[]=d.digest(str.getBytes());
		
		return new BASE64Encoder().encode(message);
		
		
	}
	
	
	
}
